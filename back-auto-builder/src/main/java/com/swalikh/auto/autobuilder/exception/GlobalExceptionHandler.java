package com.swalikh.auto.autobuilder.exception;


import com.swalikh.auto.autobuilder.utils.Result;
import com.swalikh.auto.autobuilder.websocket.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Autowired
    private SocketServer socketServer;

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e) {


//        绑定异常是需要明确提示给用户的
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
           if(exception.getResult() == null){
               String msg = exception.getCodeMsg().getMsg();
               this.sendMessage(msg);
               return Result.build(exception.getCodeMsg().getCode(),msg,
                       ExceptionUtils.getFirstStackTrace(exception));//将具体错误信息设置到CodeMsg中返回
           } else {
               this.sendMessage(exception.getResult().getMsg());
               return exception.getResult();
           }

        }
        // 其余异常简单返回为服务器异常
        this.sendMessage(ExceptionUtils.getInfo01(e));
        return Result.error(CodeMsg.SERVER_ERROR, ExceptionUtils.getInfo01(e));
    }

    public void sendMessage(String message){
        SocketServer.sendAll(message);
    }
}