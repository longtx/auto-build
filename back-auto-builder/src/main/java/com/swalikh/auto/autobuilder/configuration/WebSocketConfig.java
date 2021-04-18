package com.swalikh.auto.autobuilder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Copyright @2019 nlelpct.
 * date:  2019/7/18  14:36
 * use to：websocket开启
 * modify：
 */
@Configuration
public class WebSocketConfig {  
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){  
        return new ServerEndpointExporter();  
    }  
}  
