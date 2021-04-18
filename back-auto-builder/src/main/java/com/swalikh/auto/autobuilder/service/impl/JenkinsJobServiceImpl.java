package com.swalikh.auto.autobuilder.service.impl;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpConnection;
import com.offbytwo.jenkins.model.*;
import com.swalikh.auto.autobuilder.base.BaseServiceImpl;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.entity.Mission;
import com.swalikh.auto.autobuilder.exception.CodeMsg;
import com.swalikh.auto.autobuilder.exception.GlobalException;
import com.swalikh.auto.autobuilder.repository.JenkinsJobRepository;
import com.swalikh.auto.autobuilder.repository.MissionRepository;
import com.swalikh.auto.autobuilder.service.JenkinsJobService;
import com.swalikh.auto.autobuilder.service.MessageService;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.utils.HttpClientUtil;
import com.swalikh.auto.autobuilder.utils.JsonUtils;
import com.swalikh.auto.autobuilder.websocket.server.SocketServer;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class JenkinsJobServiceImpl extends BaseServiceImpl<JenkinsJob,String, JenkinsJobRepository> implements JenkinsJobService {


    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private JenkinsServer jenkinsServer;

    @Autowired
    private MissionService missionService;

    @Value("${project.jenkins.server-uri}")
    private String jenkinsUrl;

    @Value("${project.jenkins.username}")
    private String jenkinsUsername;

    @Value("${project.jenkins.password}")
    private String jenkinsPassword;

    private JenkinsJob jenkinsJob;

    private Mission mission;

    private Long start;

    private Long end;

    private int lastVersion;

    private int thisVersion;

    @Autowired
    private MessageService messageService;

    @Override
    public void execute(JenkinsJob jenkinsJob) {
        try {
            this.jenkinsJob = jenkinsJob;
            this.init();
            this.run();
            this.destory();
        } catch (IOException e) {
            System.out.println("GGGG---------");
        }
    }

    private void init() {
        Mission mission = missionRepository.findById(jenkinsJob.getMid()).get();
        this.mission  = mission;
        this.start = System.currentTimeMillis();
        SocketServer.sendMessage("正在执行："+jenkinsJob.getName()+",请稍后...",mission.getSocketName());
        this.lastVersion = getJobVersion();

    }
    private void run() throws IOException {
        // 2.开始执行job
        String jenkins_job_name = jenkinsJob.getJenkins_job_name();
        Map<String,String> mapParams = getJobParams();
        build(jenkins_job_name,mapParams);
        // 3.持续监测job当前状态，如果完成了就放开
        while (true){
            if(isJobdone()){
                break;
            }
        }
        if(jenkinsJob.getName().contains("maven")){
            Build lastBuild = jenkinsServer.getJob(jenkinsJob.getJenkins_job_name()).getLastBuild();
            String result = lastBuild.details().getResult().toString();
            if("FAILURE".equals(result)){
                missionService.clearVersion(mission);
                SocketServer.sendMessage("ERROR:maven编译失败！代码是否都已经上传？本次先编译测试一下！",mission.getSocketName());
                messageService.wechatMessage("【"+mission.getName()+"】Maven编译失败！");
                throw new GlobalException(CodeMsg.MAVEN_BUILD_FAILED);
            }
        }
    }


    /**
     * 时    间: 2019/8/8 10:22
     * 方法描述：检查job是否已经完成编译
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private boolean isJobdone() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.thisVersion = getJobVersion();
         if(thisVersion == lastVersion){
             return false;
         }
        String httpUrl = jenkinsUrl+"/job/"+jenkinsJob.getJenkins_job_name()+"/lastBuild/api/json";
        String s = HttpClientUtil.doGet(httpUrl,jenkinsUsername,jenkinsPassword);
        Map<String,Object> map = JsonUtils.jsonToPoJo(s, Map.class);
        String isBuild = map.get("building").toString();
        if(isBuild.equals("false")){
            return true;
        }
        return false;
    }


    /**
     * 时    间: 2019/8/7 17:23
     * 方法描述：获取当前job的构建版本，用来对比是否构建成功
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private int getJobVersion() {
        try {
            JobWithDetails job = jenkinsServer.getJob(jenkinsJob.getJenkins_job_name());
            Build lastBuild = job.getLastBuild();
            int number = lastBuild.getNumber();
            return number;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 时    间: 2019/8/7 17:01
     * 方法描述：获取当前job的params
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private Map<String,String> getJobParams() {
        String params = jenkinsJob.getParams();
        if(StringUtils.isNotBlank(params)){
            Map<String,String> map = JsonUtils.jsonToPoJo(params, Map.class);
            map.put("version",missionService.getVersion(mission.getId()));
            return map;
        }
        return null;
    }

    private void destory() {
        this.end = System.currentTimeMillis();
        SocketServer.sendMessage("任务【"+jenkinsJob.getName()+"】成功完成",mission.getSocketName());
        SocketServer.sendMessage("实际用了:【"+getTotalTime()+"】秒",mission.getSocketName());
        SocketServer.sendMessage("jenkinsJob版本号变化："+lastVersion+"--->"+thisVersion,mission.getSocketName());
    }

    /**
     * 时    间: 2019/8/7 16:21
     * 方法描述：获取总共使用的时长
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private Long getTotalTime() {
        Long total = end - start;
        return total/1000;
    }

    /**
     * 时    间: 2019/8/7 16:20
     * 方法描述：获取所有jenkins中所有的任务
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private Map<String, Job> getAllJobs(){
        Map<String, Job> jobs = null;
        try {
             jobs = jenkinsServer.getJobs();
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.JENKINS_CONNECT_ERROR);
        }
        return jobs;
    }

    /**
     * 时    间: 2019/8/7 16:23
     * 方法描述：判断jenkins是否存在该job 存在返回true 不存在返回false
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private void validateJob(String jobName) {
        Map<String, Job> allJobs = getAllJobs();
        for (Map.Entry<String, Job> jobEntry : allJobs.entrySet()) {
            if(jobEntry.getKey().equals(jobName)){
                return;
            }
        }
        throw new GlobalException(CodeMsg.JENKINS_JOB_NOT_EXIST.fillArgs(jobName));
    }


    /**
     * 时    间: 2019/8/7 16:20
     * 方法描述：开始 build jenkins 任务
     * 返回类型：
     * 修改内容：（若修改了请注明修改人，修改时间，修改内容）
     */
    private void build(String jobName,Map<String,String> mapParams){
        validateJob(jobName);
        try {
            JobWithDetails job = jenkinsServer.getJob(jobName);
            if(mapParams ==  null){
                job.build();
            } else {
                job.build(mapParams);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.JENKINS_BUILD_ERROR.fillArgs(jobName));
        }
    }

    @Override
    public JenkinsJob getEntityType() {
        return new JenkinsJob();
    }
}
