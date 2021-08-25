package properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class MainTest {
  public static void main(String[] args) throws Exception{
    test002();
  }
  // 写入
  public static void test001() throws Exception{
    Properties properties = new Properties();

    FileOutputStream oFile = new FileOutputStream("b.properties",true);
    properties.setProperty("phone", "10086");
    properties.store(oFile, "The New properties file");
    oFile.close();
  }
  // 读取
  public static void test002() throws Exception{
    Properties prop = new Properties();
    //读取属性文件a.properties
    InputStream in = new BufferedInputStream(new FileInputStream("b.properties"));
    prop.load(in);     ///加载属性列表
    System.out.println(prop.getProperty("phone"));
  }
}
