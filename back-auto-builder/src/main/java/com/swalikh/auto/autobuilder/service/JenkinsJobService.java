package com.swalikh.auto.autobuilder.service;

import com.swalikh.auto.autobuilder.base.BaseService;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.repository.JenkinsJobRepository;
import com.swalikh.auto.autobuilder.utils.Result;

public interface JenkinsJobService extends BaseService<JenkinsJob,String, JenkinsJobRepository> {


    void execute(JenkinsJob jenkinsJob);


}
