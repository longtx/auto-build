package com.swalikh.auto.autobuilder.service.impl;

import com.swalikh.auto.autobuilder.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;

@Service
@Slf4j
@SuppressWarnings("all")
public class MessageServiceImpl implements MessageService {


    private String dingUrl = "http://192.168.10.14:10093/ding/send";
    private String wechatUrl = "http://192.168.10.14:10093/wechat/sendAtAll";


    @Override
    public void sendDingMessage(String message) {
        send(message,dingUrl);
    }

    @Override
    public void wechatMessage(String message) {
        send(message,wechatUrl);
    }

    private void send(String message,String url){

        log.info("发送消息service，接受的参数为：【url={},message={}】", url,message);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            builder.addParameter("message", message);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8"); // UTF-8
                log.info("发送消息成功：返回参数为：{}",resultString);
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
    }
}
