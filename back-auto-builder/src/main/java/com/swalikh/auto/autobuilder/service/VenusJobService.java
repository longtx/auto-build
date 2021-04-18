package com.swalikh.auto.autobuilder.service;

import com.swalikh.auto.autobuilder.base.BaseService;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.entity.VenusJob;
import com.swalikh.auto.autobuilder.repository.JenkinsJobRepository;
import com.swalikh.auto.autobuilder.repository.VenusJobRepository;
import com.swalikh.auto.autobuilder.utils.Result;

public interface VenusJobService extends BaseService<VenusJob,String, VenusJobRepository> {


    void execute(VenusJob venusJob);
}
