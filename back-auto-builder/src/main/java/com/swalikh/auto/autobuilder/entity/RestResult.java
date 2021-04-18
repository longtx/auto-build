package com.swalikh.auto.autobuilder.entity;

import lombok.Data;

@Data
public class RestResult {

    private int code;

    private String msg;

    private Object data;

    public static RestResult ok(String message,Object data) {
        RestResult result = new RestResult();
        result.setCode(0);
        result.setMsg(message);
        result.setData(data);
        return result;
    }

    public static RestResult ok(String message) {
        RestResult result = new RestResult();
        result.setCode(0);
        result.setMsg(message);
        result.setData(null);
        return result;
    }

    public static RestResult err(String message) {
        RestResult result = new RestResult();
        result.setCode(401);
        result.setMsg(message);
        result.setData(null);
        return result;
    }
}
