package com.swalikh.auto.autobuilder.controller;

import com.swalikh.auto.autobuilder.base.BaseController;
import com.swalikh.auto.autobuilder.entity.JenkinsJob;
import com.swalikh.auto.autobuilder.entity.VenusJob;
import com.swalikh.auto.autobuilder.service.JenkinsJobService;
import com.swalikh.auto.autobuilder.service.VenusJobService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venus")
public class VenusJobController extends BaseController<VenusJob, VenusJobService> {



}
