package http;

import http.util.SSLUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MainTest {
  private static final String URL1 = "http://localhost:30001/listUsers/3/100";
  private static final String URL2 = "https://randomuser.me/api";
  private static final String URL3 = "https://www.baidu.com/";


  public static void main(String[] args) throws Exception{
    System.out.println(HttpUtils.doGet2(URL2));
  }
  public static void test001() throws Exception{
    String url = URL2;
    // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 创建Get请求
    HttpGet httpGet = new HttpGet(url);
    // 由客户端执行(发送)Get请求
    CloseableHttpResponse response = httpClient.execute(httpGet);
    // 从响应模型中获取响应实体
    HttpEntity responseEntity = response.getEntity();
    System.out.println("响应状态为:" + response.getStatusLine());
    if (responseEntity != null) {
      System.out.println("响应内容长度为:" + responseEntity.getContentLength());
      System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
    }

    if (httpClient != null) {
      httpClient.close();
    }
    if (response != null) {
      response.close();
    }
  }
  // 访问的是 http url，不需要绕过 SSL 认证
  public static void test002() throws IOException {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet("http://www.baidu.com");
    System.out.println("Executing request " + httpGet.getRequestLine());
    // create a custom response handler
    ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
      @Override
      public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
        int status = httpResponse.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
          HttpEntity entity = httpResponse.getEntity();
          return entity != null ? EntityUtils.toString(entity) : null;
        } else {
          throw new ClientProtocolException("Unexpected response status: " + status);
        }
      }
    };
    String responseBody = httpClient.execute(httpGet,responseHandler);
    System.out.println("--------------------------------------------");
    System.out.println(responseBody);
  }

  /**
   * 访问 https url
   * 绕过 SSL 认证
   *
   * @throws IOException
   */
  public static void test003() throws IOException, NoSuchAlgorithmException, KeyManagementException {
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
    HttpGet httpGet = new HttpGet("https://www.baidu.com");
    httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
    httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");

    CloseableHttpResponse response = client.execute(httpGet);
    HttpEntity entity = response.getEntity();
    if(entity != null) {
      body = EntityUtils.toString(entity, "UTF-8");
    }

    EntityUtils.consume(entity);
    response.close();
    System.out.println("body:" + body);
    client.close();
  }
}
