package com.swalikh.auto.autobuilder.controller;

import com.swalikh.auto.autobuilder.base.BaseController;
import com.swalikh.auto.autobuilder.entity.Mission;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.utils.LocalStorageUtils;
import com.swalikh.auto.autobuilder.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * Copyright @2019 nlelpct.
 * date:  2019/6/18  11:48
 * use to：企业类接口
 * modify：
 */
@RestController
@RequestMapping("/mission")
public class MissionController extends BaseController<Mission, MissionService> {


    private Logger logger = LoggerFactory.getLogger(MissionController.class);

    @Autowired
    private MissionService missionService;

    @PostMapping("/start/{id}")
    public Result startMission(@PathVariable String id , HttpServletRequest request){
        String ipaddr = request.getRemoteAddr();
        LocalStorageUtils.setCurrentIp(ipaddr);
        logger.info("IP地址为：【{}】的用户，执行了打包的程序！MISSION的ID为：【{}】",ipaddr,id);
        missionService.startMission(id);
        return Result.ok("发送指令成功！");
    }


}
