package http.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.net.URL;

public class JsoupFirstTest {

    /**
     * 虽然使用Jsoup可以替代HttpClient直接发起请求解析数据，但是往往
     * 不会这样用，因为实际的开发过程中，需要使用多线程，连接池，代理
     * 等等方式，而jsoup对这些的支持并不是很好，所以我们一般把jsoup
     * 仅仅作为html解析工具使用
     * @throws Exception
     */
    @Test
    public void testUrl() throws Exception{
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"),1000);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }
}
