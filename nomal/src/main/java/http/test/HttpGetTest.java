package http.test;

import common.PrintUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetTest {
    /**
     * 打印消息体，以及消息体的长度
     * @param args
     */
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet =new HttpGet("http://www.itcast.cn");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //解析响应
            if(response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                PrintUtils.printDelimiter("content");
                System.out.println(content);
                PrintUtils.printDelimiter("content.length()");
                System.out.println(content.length());
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
