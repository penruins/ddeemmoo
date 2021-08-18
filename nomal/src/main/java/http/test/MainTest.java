package http.test;

import http.HttpUtils;
import http.HttpUtils2;
import org.junit.Test;

public class MainTest {
  private static final String URL001 = "http://localhost:30001/listUsers/3/100";
  private static final String GET_REQUEST_INFORMATION = "http://localhost:30001/getRequestInformation";
  @Test
  public void test001() throws Exception{
    System.out.println(HttpUtils.doGet(URL001));
  }
  @Test
  public void test002() {
    System.out.println(HttpUtils2.doGet(URL001));
  }
  @Test
  public void test003() {
    System.out.println(HttpUtils2.doGet(GET_REQUEST_INFORMATION));
  }
}
