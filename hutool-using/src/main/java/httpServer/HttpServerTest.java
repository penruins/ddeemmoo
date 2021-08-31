package httpServer;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;

/**
 * https://www.hutool.cn/docs/#/http/Server/%E7%AE%80%E6%98%93Http%E6%9C%8D%E5%8A%A1%E5%99%A8-SimpleServer
 *
 */
public class HttpServerTest {
  public static void main(String[] args) {
    test002();
  }
  public static void test001() {
    HttpUtil.createServer(8888)
      .addAction("/",((httpServerRequest, httpServerResponse) -> {
          httpServerResponse.write("Hello Hutool Server");
        })
      ).start();
  }
  public static void test002() {
    HttpUtil.createServer(8888)
      // 返回JSON数据测试
      .addAction("/restTest", (request, response) ->
        response.write("{\"id\": 1, \"msg\": \"OK\"}", ContentType.JSON.toString())
      ).start();
  }
}
