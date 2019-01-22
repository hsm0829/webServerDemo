package com.web.httpClient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * http请求工具类
 */
public class HttpUtil {

    public void httpClientGet(String post_url, String token) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet get = new HttpGet(post_url);
        get.setHeader("Authorization", "token "+token);
        HttpResponse response = httpclient.execute(get);
        // 获得响应的实体对象
        HttpEntity entity = response.getEntity();
        // 使用Apache提供的工具类进行转换成字符串
        String responseStr = EntityUtils.toString(entity, "UTF-8");
        System.out.println("请求数据返回："+responseStr);
        httpclient.getConnectionManager().shutdown();
    }
}
