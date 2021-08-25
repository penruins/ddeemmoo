package xml;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public class XmlDemo {
  private static String XML_NAME = "request_20210708100645087445.xml";
  public static void main(String[] args) throws DocumentException {
    test002();
  }
  public static void test001() throws DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(new File("request_20210708100645087445.xml"));
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
  public static void test002() throws DocumentException {
    FtpUtil ftpUtil = new FtpUtil("localhost",21,"Jolimark","123456","");
    System.out.println(ftpUtil.getB());
    Map map = ftpUtil.checkoutFtpPathAndFileName("/", XML_NAME);
    System.out.println(map.get("filePath"));
    System.out.println(map.get("fileName"));

    InputStream inputStreamByName = ftpUtil.getInputStreamByName("/", XML_NAME);
    byte[] fileBytesByName = ftpUtil.getFileBytesByName("/", XML_NAME);
    System.out.println(fileBytesByName.length);
    System.out.println(new String(fileBytesByName));

//    SAXReader reader = new SAXReader();
//    Document document = reader.read(inputStreamByName);
//    Element rootElement = document.getRootElement();
//    String session_id = (String) rootElement.element("session_id").getData();
//    String timestamp = (String) rootElement.element("timestamp").getData();
//    String operator = (String) rootElement.element("operator").getData();
//    String request_type = (String) rootElement.element("request_type").getData();
//    String target = (String) rootElement.element("target").getData();
//    String operation = (String) rootElement.element("operation").getData();
//    System.out.println(session_id);
//    System.out.println(timestamp);
//    System.out.println(operator);
//    System.out.println(request_type);
//    System.out.println(target);
//    System.out.println(operation);
  }
}
