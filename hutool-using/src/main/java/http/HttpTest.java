package http;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HttpTest {
  public static void main(String[] args) {
  }

  public static void test001() {
    String result1 = HttpUtil.get("https://www.baidu.com");
    System.out.println(result1);
  }
  public static void test002() {
    //TODO
  }
}
