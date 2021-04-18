package com.swalikh.auto.autobuilder.autoScheduling;


import com.swalikh.auto.autobuilder.service.MissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class AutoScheduling {


    @Autowired
    private MissionService missionService;


//    @Scheduled(cron = "0 30 8 ? * MON-FRI")
//    public void runELN(){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String format1 = format.format(new Date());
//        missionService.startMission("822");
//        log.info("{}: 开始自动打包ELN，mission编号为：【{}】" ,format1,"822");
//    }
//
//    @Scheduled(cron = "0 0 8 ? * MON-FRI")
//    public void runEXAM(){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        String format1 = format.format(new Date());
//        missionService.startMission("823");
//        log.info("{}: 开始自动打包EXAM，mission编号为：【{}】" ,format1,"823");
//    }
}

