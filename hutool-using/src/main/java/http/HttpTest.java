package http;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;


/**
 * https://www.hutool.cn/docs/#/http/Http%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%B7%A5%E5%85%B7%E7%B1%BB-HttpUtil
 */
public class HttpTest {
  public static void main(String[] args) {
    test002();
  }

  public static void test001() {
    String result1 = HttpUtil.get("https://www.baidu.com");
    System.out.println(result1);
  }
  public static void test002() {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("city","kunming");
    String result = HttpUtil.post("https://www.baidu.com",paramMap);
    System.out.println(result);
  }
}
