package http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientPoolTest {
    public static void main(String[] args) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        cm.setMaxTotal(100);
        //设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(10);
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content.length());
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
