package com.swalikh.auto.autobuilder.entity;

import lombok.Data;

@Data
public class VenusApp {

    private String id;

    private String appName;

    private String appNameKube;

    private String appKind;

    private String imageName;

    private String imageVersion;

    private String targetImageVersion;

    private String namespace;

}
