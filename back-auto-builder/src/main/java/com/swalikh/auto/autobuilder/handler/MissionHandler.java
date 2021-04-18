package com.swalikh.auto.autobuilder.handler;

import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.entity.Job;
import com.swalikh.auto.autobuilder.entity.Mission;
import com.swalikh.auto.autobuilder.entity.VenusJob;
import com.swalikh.auto.autobuilder.repository.MissionRepository;
import com.swalikh.auto.autobuilder.service.JenkinsJobService;
import com.swalikh.auto.autobuilder.service.MessageService;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.service.VenusJobService;
import com.swalikh.auto.autobuilder.websocket.server.SocketServer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @2019 nlelpct.
 * date:  2019/8/7  10:52
 * use to：全流程的处理类，用来解析mission，把它分成多步。一步一步处理
 * modify：
 */
@Service
public class MissionHandler {

    @Autowired
    private MissionService missionService;

    @Autowired(required = false)
    private JenkinsJobService jenkinsJobService;

    @Autowired(required = false)
    private VenusJobService venusJobService;

    @Autowired(required = false)
    private MissionRepository missionRepository;

    private Mission mission;

    private Long start;

    private Long end;

    @Autowired
    private MessageService messageService;

    @Async
    public void start(Mission mission){
        this.mission = mission;
        this.init();
        List<Job> jobs = mission.getJobs();
        List<Integer> progress = wrapProgress(caculateProgress(jobs.size()));
        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            // 显示当前的进度
            SocketServer.sendMessage("progress#"+progress.get(i),mission.getSocketName());
            if(JenkinsJob.class.isInstance(job)){
                JenkinsJob jenkinsJob = (JenkinsJob) job;
                SocketServer.sendMessage("############# 正在分配第【"+jenkinsJob.getStep()+"】个任务"
                        +"，任务名为:【"+jenkinsJob.getName()+"】 #############",mission.getSocketName());
                jenkinsJobService.execute(jenkinsJob);
            } else if(VenusJob.class.isInstance(job)){
                VenusJob venusJob = (VenusJob) job;
                SocketServer.sendMessage("############# 正在分配第【"+venusJob.getStep()+"】个任务"
                        +"，任务名为:【"+venusJob.getName()+"】 #############",mission.getSocketName());
                venusJobService.execute(venusJob);
            } else {
                SocketServer.sendMessage("警告：出现未知的job！"+job.toString(),mission.getSocketName());
            }

        }
        this.destroy();
    }

    private List<Integer> caculateProgress(int size) {

        int everyStep = 100/size;
        int last = 100%(everyStep*size);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if(i<last){
                list.add(everyStep+1);
                continue;
            }
            list.add(everyStep);
        }
        return list;
    }

    private List<Integer> wrapProgress(List<Integer> progress) {

        int a = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer integer : progress) {
            a = a + integer;
            list.add(a);
        }
        return list;
    }

    private void init() {
        this.start = System.currentTimeMillis();
        SocketServer.sendMessage("调度成功！开始准备更新....",mission.getSocketName());
        SocketServer.sendMessage("mission名字为：【"+mission.getName()+"】",mission.getSocketName());
        SocketServer.sendMessage("总共有：【"+mission.getModules()+"】个模块",mission.getSocketName());
        SocketServer.sendMessage("总共有：【"+mission.getJobs().size()+"】个任务",mission.getSocketName());
        SocketServer.sendMessage("大约需要用时：【"+mission.getTotal_time()+"】分钟",mission.getSocketName());
    }

    private void destroy() {
        this.end = System.currentTimeMillis();
        SocketServer.sendMessage("任务全部完成！你他么太棒了！！！",mission.getSocketName());
        SocketServer.sendMessage("完成更新，总共用了"+getTotalTime()+"分钟！",mission.getSocketName());
        SocketServer.sendMessage("welldone",mission.getSocketName());
        // 搞完要清除版本号遗留问题
        messageService.wechatMessage("【"+mission.getName()+"】系统更新完成！版本号为："+mission.getVersion()+"，请等待5分钟之后访问～");
        missionService.clearVersion(mission);
    }

    private Long getTotalTime() {
        Long total = end - start;
        return total/(60*1000);
    }
}
