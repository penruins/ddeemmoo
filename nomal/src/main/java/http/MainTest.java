package http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class MainTest {
  public static void main(String[] args) throws Exception{
    test001();
  }
  public static void test001() throws Exception{
    String url = "https://api.github.com/search/users?q=python";
    // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    // 创建Get请求
    HttpGet httpGet = new HttpGet(url);
    httpGet.setHeader("Authorization","token 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");
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
}
