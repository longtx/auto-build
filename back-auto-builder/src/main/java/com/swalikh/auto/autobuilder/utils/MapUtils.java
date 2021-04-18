package com.swalikh.auto.autobuilder.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String,String> getMap(String key,String value){
        Map<String,String> map = new HashMap();
        map.put(key,value);
        return map;
    }
}
