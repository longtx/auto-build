package com.swalikh.auto.autobuilder.service;


/**
 * Copyright @2019 nlelpct.
 * date:  2019/9/6  16:47
 * use to：提醒我自己
 * modify：
 */
public interface MessageService {

    void sendDingMessage(String message);
    void wechatMessage(String message);
}
