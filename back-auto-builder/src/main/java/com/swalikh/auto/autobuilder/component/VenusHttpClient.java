package com.swalikh.auto.autobuilder.component;

import com.swalikh.auto.autobuilder.utils.JsonUtils;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VenusHttpClient {

    @Value("${venus.username}")
    private String username;

    @Value("${venus.password}")
    private String password;

    @Value("${venus.url}")
    private String url;

    public  String doGet(String url, Map<String, String> param) {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("X-Token",getToken());
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8"); // UTF-8
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public  String doGet(String url) {
        return doGet(url, null);
    }

    public  String doPost(String url, Map<String, String> param) {
        return doPost(url,param,null);
    }



    public  String doPost(String url, Map<String, String> param,Map<String, String> header) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建header头信息
            if(header != null){
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpPost.addHeader(entry.getKey(),entry.getValue());
                }
            }
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    public  String doPost(String url) {
        return doPost(url, null);
    }

    public  String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 添加header
            httpPost = (HttpPost) addHeaders(httpPost, "Authorization", "1231321321313132132");
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    private  HttpRequestBase addHeaders(HttpRequestBase httpRequest, String key, String value) {
        // 设置请求头信息，鉴权
//        httpRequest.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
        httpRequest.setHeader(value, value);
        // 设置配置请求参数
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(35000)// 连接主机服务超时时间
                .setConnectionRequestTimeout(35000)// 请求超时时间
                .setSocketTimeout(60000)// 数据读取超时时间
                .build();
        // 为httpGet实例设置配置
        httpRequest.setConfig(requestConfig);
        return httpRequest;
    }

    private String getToken() {
        Map<String,String> param = new HashMap<>();
        param.put("loginName",username);
        param.put("loginPassword",password);

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String token = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 添加header
            httpPost = (HttpPost) addHeaders(httpPost, "Authorization", "1231321321313132132");
            // 创建请求内容
            StringEntity entity = new StringEntity(JsonUtils.objectToJson(param), ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            String resultString = EntityUtils.toString(response.getEntity(), "utf-8");

            JSONObject jsonObject = JsonUtils.jsonToPoJo(resultString, JSONObject.class);
            JSONObject data = (JSONObject) jsonObject.get("data");
            token = (String) data.get("token");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return token;
    }

    public String doPatchJson(String grayUpdateUrl, String objectToJson) {

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            HttpPatch httpPatch = new HttpPatch(grayUpdateUrl);
            httpPatch.addHeader("X-Token",getToken());
            httpPatch = (HttpPatch) addHeaders(httpPatch, "Authorization", "1231321321313132132");
            StringEntity entity = new StringEntity(objectToJson, ContentType.APPLICATION_JSON);
            httpPatch.setEntity(entity);
            response = httpClient.execute(httpPatch);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultString;
    }

}