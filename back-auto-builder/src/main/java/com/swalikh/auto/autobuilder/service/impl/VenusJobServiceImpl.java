package com.swalikh.auto.autobuilder.service.impl;

import com.swalikh.auto.autobuilder.base.BaseServiceImpl;
import com.swalikh.auto.autobuilder.entity.*;
import com.swalikh.auto.autobuilder.exception.ExceptionUtils;
import com.swalikh.auto.autobuilder.exception.GlobalException;
import com.swalikh.auto.autobuilder.repository.MissionRepository;
import com.swalikh.auto.autobuilder.repository.UserRepository;
import com.swalikh.auto.autobuilder.repository.VenusJobRepository;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.service.UserService;
import com.swalikh.auto.autobuilder.service.VenusJobService;
import com.swalikh.auto.autobuilder.service.VenusServer;
import com.swalikh.auto.autobuilder.utils.JsonUtils;
import com.swalikh.auto.autobuilder.utils.MapUtils;
import com.swalikh.auto.autobuilder.utils.Result;
import com.swalikh.auto.autobuilder.websocket.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VenusJobServiceImpl extends BaseServiceImpl<VenusJob,String, VenusJobRepository> implements VenusJobService {


    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private VenusServer venusServer;

    @Autowired
    private MissionService missionService;

    private VenusJob venusJob;

    private Mission mission;

    private Long start;

    private Long end;

    @Override
    public void execute(VenusJob venusJob) {
        try {
            this.init(venusJob);
            this.run();
            this.destory();
        } catch (Exception e) {
            e.printStackTrace();
            String errMessage = e.getMessage();
            if (e instanceof GlobalException) {
                GlobalException exception = (GlobalException) e;
                errMessage = exception.getCodeMsg().getMsg();
            }
            SocketServer.sendMessage("升级【"+venusJob.getName()+"】失败！"
                    +"原因："+errMessage
                    +",跳过本任务，执行下个任务！",mission.getSocketName());
            return;
        }
    }

    private void run() {
        // 1.获取当前应用的实际基础数据
        VenusApp venusApp = venusServer.getAppInfo(venusJob.getAppid());
        // 2.检查当前版本是否成功上传镜像
        venusServer.validateVersion(venusApp.getImageName(),venusJob.getMid());

        // 3.检验成功，构建参数，开始升级
        venusApp.setTargetImageVersion(missionService.getVersion(venusJob.getMid()));
        venusServer.grayUpdate(venusApp);

        // 4.发送消息，灰度升级成功
        SocketServer.sendMessage("升级"+venusJob.getName()+"成功！"
                +"，版本变化：【"+venusApp.getImageVersion()+"】 ---> 【"+missionService.getVersion(venusJob.getMid())
                +"】",mission.getSocketName());
    }

    private void init(VenusJob venusJob) {
        this.venusJob = venusJob;
        Mission mission = missionRepository.findById(venusJob.getMid()).get();
        this.mission  = mission;
        this.start = System.currentTimeMillis();
    }

    private void destory() throws InterruptedException {
        this.end = System.currentTimeMillis();
        Thread.sleep(1000);
    }

    private Long getTotalTime() {
        Long total = end - start;
        return total/(1000);
    }

    @Override
    public VenusJob getEntityType() {
        return new VenusJob();
    }
}
