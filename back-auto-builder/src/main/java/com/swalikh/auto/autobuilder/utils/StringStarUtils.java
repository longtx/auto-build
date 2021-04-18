package com.swalikh.auto.autobuilder.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringStarUtils {
    /**
     * 判断是否为正确的手机号
     *
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if(mobile == null || "".equals(mobile)){
            return false;
        }
        if(mobile.length()!=11){
            return false;
        }
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }



    /**
     * 判断是否为正确的邮件格式
     * @param str
     * @return boolean
     */
    public static boolean isEmail(String str){
        if(str == null || "".equals(str)){
            return false;
        }
        return str.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)+$");
    }



    /**
     * 对字符串处理:将指定位置到指定位置的字符以星号代替
     */
    public static String getStarStringFromTo(String content, int begin, int end) {
        if(content==null){
            return null;
        }

        if (begin >= content.length() || begin < 0) {
            return content;
        }
        if (end >= content.length() || end < 0) {
            return content;
        }
        if (begin >= end) {
            return content;
        }
        String starStr = "";
        for (int i = begin; i < end; i++) {
            starStr = starStr + "*";
        }
        return content.substring(0, begin) + starStr + content.substring(end, content.length());

    }

    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     */

    public static String getStarStringExcep(String content, int frontNum, int endNum) {

        if(content==null){
            return null;
        }
        if (frontNum >= content.length() || frontNum < 0) {
            return content;
        }
        if (endNum >= content.length() || endNum < 0) {
            return content;
        }
        if (frontNum + endNum >= content.length()) {
            return content;
        }
        String starStr = "";
        for (int i = 0; i < (content.length() - frontNum - endNum); i++) {
            starStr = starStr + "*";
        }
        return content.substring(0, frontNum) + starStr
                + content.substring(content.length() - endNum, content.length());
    }

    public static boolean isEmpty(String str) {
        if(str==null){
            return true;
        }
        if("".equals(str.trim())){
            return true;
        }
        return false;
    }
    //得到格式优美的入参或者出参
    public static  String  createContent(String... params){
        StringBuffer str = new StringBuffer();
        str.append("类和方法：").append("  ");
        for (String param : params) {
            str.append(param).append("  ");
        }
        return str.toString();
    }
}
