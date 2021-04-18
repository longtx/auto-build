package com.swalikh.auto.autobuilder.service;

import com.swalikh.auto.autobuilder.base.BaseService;
import com.swalikh.auto.autobuilder.entity.Mission;
import com.swalikh.auto.autobuilder.repository.MissionRepository;
import com.swalikh.auto.autobuilder.utils.Result;

public interface MissionService extends BaseService<Mission,String, MissionRepository> {

    void startMission(String id);

    String getVersion(String mid);

    String confirmVersion(Mission mission);

    void clearVersion(Mission mission);
}
