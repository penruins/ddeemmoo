import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroMD5Test {
  public static void main(String[] args) {
    // MD5加密，无随机盐，无散列
    Md5Hash md5Hash01 = new Md5Hash("123456");
    System.out.println(md5Hash01.toHex());

    // MD5+随机盐加密，无散列
    Md5Hash md5Hash02 = new Md5Hash("123456","1q2w3e");
    System.out.println(md5Hash02.toHex());

    // MD5+随机盐加密+散列1024
    Md5Hash md5Hash03 = new Md5Hash("123456","1q2w3e",1024);
    System.out.println(md5Hash03.toHex());
  }
}
