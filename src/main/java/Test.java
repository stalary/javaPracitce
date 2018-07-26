import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
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
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
        HttpGet httpGet = new HttpGet("https://api.douban.com/v2/movie/top250");
        HttpEntity entity = client.execute(httpGet).getEntity();
        String s = EntityUtils.toString(entity);
        JSONObject j1 = JSONObject.parseObject(s);
        JSONArray jsonArray = j1.getJSONArray("subjects");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String title = jsonObject.getString("title");
            System.out.println((i + 1) + " : " + title);
        }
    }
}