package com.swalikh.auto.autobuilder.utils;

import com.swalikh.auto.autobuilder.entity.User;
import com.swalikh.auto.autobuilder.service.UserService;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalStorageUtils {

    private  static String currentIp;

    public static void setCurrentIp(String ipaddr) {
        currentIp = ipaddr;
    }
    public static String getCurrentIp() {
        return currentIp;
    }
    public static String getCurrentUser() {
        String s = getIpAndUserMap().get(currentIp);
        if(StringUtils.isEmpty(s)){
            return getCurrentIp();
        }else {
            return s;
        }
    }

    private static Map<String,String> getIpAndUserMap() {
        UserService userService = SpringUtil.getBean(UserService.class);
        List<User> all = userService.getAll();
        Map<String,String> map = new HashMap<>();
        map.put("192.168.11.9","黄磊");
        map.put("192.168.11.8","龙土兴");
        map.put("192.168.11.5","杨运军");
        map.put("192.168.11.6","刘文");
        map.put("192.168.11.21","肖松钊");
        map.put("192.168.11.26","周飞");
        all.forEach( ele -> {
            map.put(ele.getIp(),ele.getName());
        });
        return map;
    }

    public static void clear() {
        currentIp = null;
    }
}
