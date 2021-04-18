package com.swalikh.auto.autobuilder.service;

import com.swalikh.auto.autobuilder.entity.VenusApp;

import java.util.Map;

public interface VenusServer {

    VenusApp getAppInfo(String appid);

    void validateVersion(String imageName, String mid);

    void grayUpdate(VenusApp venusApp);
}
