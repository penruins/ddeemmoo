package com.hikvision.ftp;

import java.io.IOException;

public class FTPUtilsTest {
  public static void main(String[] args) throws IOException {
    test003();
  }

  public static void test001() {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.makeDirectory("hello3");
  }
  public static void test002() {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.downloadFile("./","1.txt","./");
  }
  // exist files
  public static void test003() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    ftpUtils.ftpClient.enterLocalPassiveMode();
    boolean b = ftpUtils.existFile("/hello2/helloo");
    System.out.println(b);
  }
  // print working directory
  public static void test004() throws IOException {
    FTPUtils ftpUtils = new FTPUtils();
    ftpUtils.initFtpClient();
    String s = ftpUtils.ftpClient.printWorkingDirectory();
    System.out.println(s);
  }
  // list files /
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
}
