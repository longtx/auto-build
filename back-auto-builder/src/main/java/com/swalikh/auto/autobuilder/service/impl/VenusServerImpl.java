package com.swalikh.auto.autobuilder.service.impl;

import com.swalikh.auto.autobuilder.component.VenusHttpClient;
import com.swalikh.auto.autobuilder.entity.VenusApp;
import com.swalikh.auto.autobuilder.exception.CodeMsg;
import com.swalikh.auto.autobuilder.exception.GlobalException;
import com.swalikh.auto.autobuilder.service.MissionService;
import com.swalikh.auto.autobuilder.service.VenusServer;
import com.swalikh.auto.autobuilder.utils.JsonUtils;
import com.swalikh.auto.autobuilder.utils.MapUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VenusServerImpl implements VenusServer {

    @Autowired
    private VenusHttpClient venusHttpClient;

    @Autowired
    private MissionService missionService;

    @Value("${platform.api.appInfoUrl}")  // 获取发布应用的信息
    private String appInfoUrl;

    @Value("${platform.api.imageListUrl}") // 获取镜像列表
    private String imageListUrl;

    @Value("${platform.api.grayUpdateUrl}")  // 灰度升级
    private String grayUpdateUrl;

//                    "id": "b0026e82325a4c07b1e636bef8707acb",
//                    "appName": "物料管理---公共模块-测试",
//                    "appNameKube": "common-service-test",
//                    "appKind": "Deployment",
//                    "imageName": "testns/common-service",
//                    "imageVersion": "v1.0.9",
//                    "namespace": "testns",
//                    "described": "物料管理---公共模块-测试",
//                    "createTime": "2019-05-18 05:47:21",
//                    "lastUpdateTime": "2019-08-12 14:55:27",
//                    "status": "运行中",
//                    "timeDiff": "87天前",

    @Override
    public VenusApp getAppInfo(String appid) {
        VenusApp venusApp = new VenusApp();
        String s = venusHttpClient.doGet(appInfoUrl+appid);
        JSONObject data = (JSONObject) JsonUtils.jsonToPoJo(s, JSONObject.class).get("data");
        venusApp.setId(appid);
        venusApp.setAppName(data.get("appName").toString());
        venusApp.setAppNameKube(data.get("appNameKube").toString());
        venusApp.setAppKind(data.get("appKind").toString());
        venusApp.setImageName(data.get("imageName").toString());
        venusApp.setImageVersion(data.get("imageVersion").toString());
        venusApp.setNamespace(data.get("namespace").toString());
        return venusApp;
    }

    @Override
    public void validateVersion(String imageName, String mid) {
        String new_version = missionService.getVersion(mid);
        // 检查当前版本在harbor中到底存不存在
        Map<String, String> param = MapUtils.getMap("imageName", imageName);
        String s = venusHttpClient.doGet(imageListUrl, param);
        if(s.contains(new_version)){
            return;
        }
        throw new GlobalException(CodeMsg.NEW_IMAGE_NOT_FOUND.fillArgs(imageName+" 版本为："+new_version));
    }

    @Override
    public void grayUpdate(VenusApp venusApp) {
        String s = venusHttpClient.doPatchJson(grayUpdateUrl,JsonUtils.objectToJson(venusApp));
        System.out.println(s);
    }


}
