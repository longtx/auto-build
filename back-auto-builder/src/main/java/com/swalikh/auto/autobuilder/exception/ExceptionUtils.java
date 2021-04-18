package com.swalikh.auto.autobuilder.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExceptionUtils {

    public static String getFirstStackTrace(Exception ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        return stackTrace[0].toString();
    }

    //2、获取RuntimeException关键的信息
    public static String getInfo01(Exception ex) {
        String sOut = "";
        StackTraceElement[] stackTrace = ex.getStackTrace();
        String type = ex.toString();
        sOut = type + " : " + stackTrace[0];
        return sOut;
    }

    public static String getInfo01(Throwable error) {
        String info = "";
        StackTraceElement[] stackTrace = error.getStackTrace();
        String type = error.toString();
        info = type + " : " + stackTrace[0];
        return info;
    }

    //3、获取RuntimeException全部的信息
    public static String getInfo02(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = new String(out.toByteArray());
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
        }
        return ret;
    }


}
