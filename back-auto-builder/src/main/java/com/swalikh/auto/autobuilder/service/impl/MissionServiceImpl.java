package com.swalikh.auto.autobuilder.service.impl;

import com.swalikh.auto.autobuilder.base.BaseServiceImpl;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.entity.Job;
import com.swalikh.auto.autobuilder.entity.Mission;
import com.swalikh.auto.autobuilder.entity.VenusJob;
import com.swalikh.auto.autobuilder.exception.CodeMsg;
import com.swalikh.auto.autobuilder.exception.GlobalException;
import com.swalikh.auto.autobuilder.handler.MissionHandler;
import com.swalikh.auto.autobuilder.repository.JenkinsJobRepository;
import com.swalikh.auto.autobuilder.repository.MissionRepository;
import com.swalikh.auto.autobuilder.repository.VenusJobRepository;
import com.swalikh.auto.autobuilder.service.MessageService;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.utils.LocalStorageUtils;
import com.swalikh.auto.autobuilder.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@EnableAsync
public class MissionServiceImpl extends BaseServiceImpl<Mission,String, MissionRepository> implements MissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private MissionService missionService;

    @Autowired
    private JenkinsJobRepository jenkinsJobRepository;

    @Autowired
    private VenusJobRepository venusJobRepository;

    @Autowired
    private MissionHandler missionHandler;

    @Autowired
    private MessageService messageService;

    @Override
    public void startMission(String id) {

        // 如果已经有任务在打包了，就抛出异常别打包了额
        List<Mission> all = missionRepository.findAll(Example.of(new Mission().setZt(1)));
        if(all.size() > 0){
            throw new GlobalException(CodeMsg.ON_BUILDING.fillArgs(all.get(0).getName()));
        }
        // 获取所有的任务
        Mission mission = missionService.getByID(id);
        if (mission == null){
            throw new RuntimeException("不存在该mission："+id);
        }
        List<JenkinsJob> jenkinsJobs = jenkinsJobRepository.findAll(Example.of(new JenkinsJob().setMid(mission.getId())), Sort.by("step"));
        List<VenusJob> venusJobs = venusJobRepository.findAll(Example.of(new VenusJob().setMid(mission.getId())), Sort.by("step"));
        List<Job> jobs = new ArrayList<>();
        jobs.addAll(jenkinsJobs);
        jobs.addAll(venusJobs);
        mission.setJobs(jobs);
        // 确定版本控制和 正在打包标签
        String confirmVersion = confirmVersion(mission);
        // 开搞
        missionHandler.start(mission);
        messageService.wechatMessage("【"+LocalStorageUtils.getCurrentUser()+"】正在打包升级【"+mission.getName()+"】~ 本次的版本为:"+confirmVersion);
        return;
    }

    @Override
     public String confirmVersion(Mission mission) {
        String versionNo = "";
        String strategy = mission.getStrategy();
        // 如果策略不填，或者为auto 为生产日期时间版本号
        if(StringUtils.isBlank(strategy) || strategy.equals("auto")){
            DateFormat format = new SimpleDateFormat("MMddHHmm");
            format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            String dateStr = format.format(new Date());
            versionNo = "v" + dateStr;
            Mission mission1 = mission.setVersion(versionNo).setZt(1);
            missionRepository.saveAndFlush(mission1);
        } else if(strategy.equals("general")){   // 如果为 general 就需要输入新的版本号
            String version = mission.getVersion();
            if(StringUtils.isBlank(version)){
                throw new GlobalException(CodeMsg.VERSION_NOT_DEFINED.fillArgs("mission名为："+mission.getName()));
            }
        } else {
            throw new GlobalException(CodeMsg.VERSION_STRATEGY_UNKNOWN.fillArgs("mission名为："+mission.getName()));
        }
        return versionNo;
    }

    @Override
    public void clearVersion(Mission mission) {
        mission.setVersion("").setZt(0);
        missionRepository.saveAndFlush(mission);
    }

    @Override
    public String getVersion(String mid) {
        Mission mission = missionRepository.getOne(mid);
        String version = mission.getVersion();
        if(StringUtils.isBlank(version)){
            throw new GlobalException(CodeMsg.VERSION_NOT_DEFINED.fillArgs("mission名为："+mission.getName()));
        }
        return version;
    }

    @Override
    public Mission getEntityType() {
        return new Mission();
    }
}
