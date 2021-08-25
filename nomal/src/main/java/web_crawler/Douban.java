package web_crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * 爬取豆瓣电影top250
 */
public class Douban {
  public static void main(String[] args) throws Exception{
    String s1 = "https://movie.douban.com/top250?start=";
    String s2 = "&filter=";
    String link = null;   // 电影的链接
    String title = null;  // 电影名称
    String score = null;  // 电影评分
    String num = null ;   // 获取评价人数
    // 存储待爬取的网址url链接
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i <= 225; i += 25) {
      list.add(s1+i+s2);
    }
    // 遍历url集合 爬取网页数据
    for (String string : list) {
      Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:60.0) Gecko/20100101 Firefox/60.0").timeout(6000).get();
      Element content = doc.getElementById("content");
      Elements infos = content.getElementsByClass("info");
      for (Element element : infos) {
        Element links = element.getElementsByTag("a").get(0);
        Element star = element.getElementsByClass("star").get(0);
        link = links.attr("href");        // 获取电影的链接
        title = links.child(0).html();    // 获取电影名称
        score = star.child(1).html();     // 获取电影评分
        num = star.child(3).html();       // 获取评价人数
        System.out.println(link + "\t" + title + "\t评分" + score + "\t" + num);
      }
    }
  }
}
