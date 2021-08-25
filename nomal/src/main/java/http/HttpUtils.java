package http;

import http.util.SSLUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class HttpUtils {

  /**
   * 普通的http 请求可以用这个
   * 它不能绕开 ssl 认证
   *
   * nomal http request can use this method
   * it cannot steer clear of SSL sertification
   * @param url
   * @return
   * @throws Exception
   */
  public static String doGet(String url) throws Exception{
    // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 创建Get请求
    HttpGet httpGet = new HttpGet(url);
    // 由客户端执行(发送)Get请求
    CloseableHttpResponse response = httpClient.execute(httpGet);
    // 从响应模型中获取响应实体
    HttpEntity responseEntity = response.getEntity();
    String result = EntityUtils.toString(responseEntity);

    if (httpClient != null) {
      httpClient.close();
    }
    if (response != null) {
      response.close();
    }
    return result;
  }

  public static String doGet2(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
    String body = null;
    // 采用绕过验证的方式处理 https 请求
    SSLContext sslContext = SSLUtils.createIgnoreVerifySSL();

    // 设置协议http 和 https 对应的处理 socket 链接工厂的对象
    Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
      .register("http", PlainConnectionSocketFactory.INSTANCE)
      .register("https", new SSLConnectionSocketFactory(sslContext))
      .build();
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
    HttpClients.custom().setConnectionManager(connectionManager);


    // 创建自定义的 httpclient 对象
    CloseableHttpClient client = HttpClients.custom().setConnectionManager(connectionManager).build();
    //CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(url);
    httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
    httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

    CloseableHttpResponse response = client.execute(httpGet);
    HttpEntity entity = response.getEntity();
    if(entity != null) {
      body = EntityUtils.toString(entity, "UTF-8");
    }

    EntityUtils.consume(entity);
    response.close();
    client.close();
    return body;
  }
}
