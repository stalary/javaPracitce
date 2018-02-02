/**
 * @(#)WanTiKu.java, 2018-01-10.
 * <p>
 * Copyright 2018 Youdao, Inc. All rights reserved.
 * YOUDAO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.stalary.web.wantiku;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * WanTiKu
 *
 * @author lirongqian
 * @since 2018/01/10
 */
@Slf4j
public class WanTiKu {

    private static final CloseableHttpClient client;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        RequestConfig requestConfig = RequestConfig.custom()
                /** 创建连接的超时时间 **/
                .setConnectTimeout(5000)
                /** 从connection manager中获取连接的最大等待时间 **/
                .setConnectionRequestTimeout(5000)
                /** 请求的超时时间 **/
                .setSocketTimeout(5000)
                .build();
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(100);
        client = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper jackson = new ObjectMapper();
        jackson.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String s = httpJsonGet("https://api.566.com/APP/exam8/Tiku/Paper/430/16447154/169909515/GetPaper/_apple/780063694f3d6c912c10944050db7506");
        JsonNode jsonNode = jackson.readTree(s).get("PaperResult").get("PaperEntity");
        System.out.println(jsonNode);
//        Test test = jackson.treeToValue(jsonNode, Test.class);
//        System.out.println(test);
//        GetPapersResult get = jackson.treeToValue(jackson.readTree(s).get("GetPapersResult"), GetPapersResult.class);
//        System.out.println(get);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Test {
        String S;
        String ErrorCode;
        String Msg;
        long SubjectId;
        List<String> EntityList;
        List<String> PageModel;
        String PrevUserExamPaperEntity;

    }


    public static String httpJsonGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        // try-with-resources
        try (CloseableHttpResponse ret = get(httpGet)) {
            int statusCode = ret.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                log.warn("request failed with code:" + statusCode);
                return null;
            }
            HttpEntity entity = ret.getEntity();
            String responseStr = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            log.info("httpJsonGet: " + url + "; " + responseStr);
            return responseStr;
        } catch (Exception e) {
            log.warn("httpJsonGet failure!", e);
            return null;
        }
    }

    public static CloseableHttpResponse get(HttpGet httpGet) throws IOException {
        return client.execute(httpGet);
    }
}