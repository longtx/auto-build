package com.swalikh.auto.autobuilder.controller;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.BuildResult;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.swalikh.auto.autobuilder.base.BaseController;
import com.swalikh.auto.autobuilder.entity.*;
import com.swalikh.auto.autobuilder.repository.JenkinsJobRepository;
import com.swalikh.auto.autobuilder.service.JenkinsJobService;
import com.swalikh.auto.autobuilder.service.UserService;
import com.swalikh.auto.autobuilder.service.VenusJobService;
import com.swalikh.auto.autobuilder.service.VenusServer;
import com.swalikh.auto.autobuilder.utils.JsonUtils;
import com.swalikh.auto.autobuilder.utils.TextToVoice;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


/**
 * Copyright @2019 nlelpct.
 * date:  2019/6/18  11:48
 * use to：用户类接口
 * modify：
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, UserService> {

    private  Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private JenkinsJobService jenkinsJobService;

    @Autowired
    private JenkinsJobRepository jenkinsJobRepository;

    @Autowired
    private VenusJobService venusJobService;

    @Autowired
    private VenusServer venusServer;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RestResult login(@RequestBody User user){
        logger.info("用户【{}】登录成功！密码为：【{}】",user.getUsername(),user.getPassword());
        return userService.login(user);
    }

    @GetMapping("/say")
    public void login(@RequestParam String words){
        TextToVoice.textToSpeech(words);
    }


    @Test
    public void run() throws Exception {
        JenkinsServer server = new JenkinsServer(new URI("http://k8s.nlaelpct.com:9080"),"admin","Kenuo.2018");
        JobWithDetails job = server.getJob("exam-admin-backend-maven");
        Build lastBuild = job.getLastBuild();
        BuildWithDetails details = lastBuild.details();
        BuildResult result = details.getResult();
        String s = result.toString();
        String s1 = JsonUtils.objectToJson(result);
    }
}
