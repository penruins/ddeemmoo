package com.hikvision.ftp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;

public class FTPUtilsTest {

  private static String XML_NAME = "request_20210708100645087445.xml";
  public static void main(String[] args) throws IOException, DocumentException {
    test007();
  }

  /**
   * 如果 ftp 服务没有开启，会直接报错
   */
  public static void test0001_1() {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
  }

  /**
   * 新建一个目录 hello3
   */
  public static void test001() {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.ftpClient.enterLocalPassiveMode();
    ftpUtils.makeDirectory("hello3");
  }
  public static void test002() {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.downloadFile("./","1.txt","./");
  }

  /**
   *
   * 是否在根目录下存在 hello这个目录
   * @throws IOException
   */
  public static void test003() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    // 必须加上这行代码
    ftpUtils.ftpClient.enterLocalPassiveMode();
    // 这个目录是我自己创建的
    boolean b = ftpUtils.existFile("/hello3/hello.txt");
    System.out.println(b);
  }
  // print working directory
  public static void test004() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    String s = ftpUtils.ftpClient.printWorkingDirectory();
    System.out.println(s);
  }
  // list files
  public static void test005() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    /**
     * 调用 FTPClient.enterLocalPassiveMode();这个方法的意思就是每次数据连接之前，
     * ftp client 告诉 ftp server 开通一个端口来传输数据。为什么要这样做呢，
     * 因为 ftp server 可能每次开启不同的端口来传输数据，但是在 linux 上，
     * 由于安全限制，可能某些端口没有开启，所以就出现阻塞。
     */
    ftpUtils.ftpClient.enterLocalPassiveMode();
    int length = ftpUtils.ftpClient.listFiles("/").length;
    System.out.println(length);
  }
  public static void test006() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.ftpClient.enterLocalPassiveMode();
    //ftpUtils.downloadFile("/",XML_NAME,"C:\\Users\\liuxiang37\\IdeaProjects\\ddeemmoo");
    // 保存到根目录下
    ftpUtils.downloadFile("/",XML_NAME,"./");
  }
  public static void test007() throws IOException, DocumentException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.ftpClient.enterLocalPassiveMode();
    //ftpUtils.downloadFile("/",XML_NAME,"C:\\Users\\liuxiang37\\IdeaProjects\\ddeemmoo");
    // 保存到根目录下
    InputStream fileStream = ftpUtils.getFileStream("/", XML_NAME, "./");
    System.out.println(fileStream);

    SAXReader reader = new SAXReader();
    Document document = reader.read(fileStream);
    Element rootElement = document.getRootElement();
    String session_id = (String) rootElement.element("session_id").getData();
    String timestamp = (String) rootElement.element("timestamp").getData();
    String operator = (String) rootElement.element("operator").getData();
    String request_type = (String) rootElement.element("request_type").getData();
    String target = (String) rootElement.element("target").getData();
    String operation = (String) rootElement.element("operation").getData();
    System.out.println(session_id);
    System.out.println(timestamp);
    System.out.println(operator);
    System.out.println(request_type);
    System.out.println(target);
    System.out.println(operation);
  }
}
