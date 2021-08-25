package http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * 带参数的get请求
 */
public class HttpGetParamTest {
    public static void main(String[] args) throws URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder urlBuilder = new URIBuilder("http://yun.itheima.com/search");
        urlBuilder.setParameter("keys","java");
        HttpGet httpGet =new HttpGet(urlBuilder.build());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //解析响应
            if(response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //关闭httpClient
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
