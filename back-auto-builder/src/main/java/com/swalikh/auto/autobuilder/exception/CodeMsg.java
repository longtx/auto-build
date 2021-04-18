package com.swalikh.auto.autobuilder.exception;


import com.swalikh.auto.autobuilder.utils.Result;

public class CodeMsg {

    private int code;
    private String msg;

    //全局通用
    public static CodeMsg SERVER_ERROR = new CodeMsg(520520, "服务端异常！");
    public static final CodeMsg DATA_ERROR = new CodeMsg(400100, "常规数据有误！%s");
    public static final CodeMsg PARAMS_NULL = new CodeMsg(400100, "参数不能为空！%s");
    public static final CodeMsg CAN_NOT_FIND = new CodeMsg(400100, "找不到该数据！%s");
    public static final CodeMsg VERSION_NOT_DEFINED = new CodeMsg(400100, "标准版本号未定义，请定义后再发布！%s");
    public static final CodeMsg VERSION_STRATEGY_UNKNOWN = new CodeMsg(400100, "版本控制策略不认识！%s");

    //jenkins 执行器
    public static final CodeMsg JENKINS_CONNECT_ERROR = new CodeMsg(500100, "jenkins出现连接异常！%s");
    public static final CodeMsg JENKINS_BUILD_ERROR = new CodeMsg(500100, "jenkins编译异常！job为：%s,磊哥经验判断是构建参数不合理！检查下构建参数！");
    public static final CodeMsg JENKINS_JOB_NOT_EXIST = new CodeMsg(500100, "jenkins服务器没有该job！job为：%s");
    public static final CodeMsg ON_BUILDING = new CodeMsg(500100, "【%s】正在发布更新！请等哈子！");
    public static final CodeMsg MAVEN_BUILD_FAILED = new CodeMsg(500301, "检查代码，maven编译失败！");

    // venus 执行器
    public static final CodeMsg NEW_IMAGE_NOT_FOUND = new CodeMsg(500100, "新版本镜像没有找到！镜像名为为：%s");
    //管理员登录
    public static final CodeMsg ACCOUNT_IS_DISABLED = new CodeMsg(500301, "您的账号已禁用！");
    public static final CodeMsg ACCOUNT_OR_PASSWORD_ERROR = new CodeMsg(500302, "账号或者密码不正确！");
    public static final CodeMsg TRYINGNOMORE = new CodeMsg(500303, "尝试次数过多！");


    //HTTP服务模块

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(msg, args);
        return new CodeMsg(code, message);
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
