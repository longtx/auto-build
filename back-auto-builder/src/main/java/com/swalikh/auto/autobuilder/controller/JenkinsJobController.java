package com.swalikh.auto.autobuilder.controller;

import com.swalikh.auto.autobuilder.base.BaseController;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.service.JenkinsJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jenkins")
public class JenkinsJobController extends BaseController<JenkinsJob, JenkinsJobService> {



}
