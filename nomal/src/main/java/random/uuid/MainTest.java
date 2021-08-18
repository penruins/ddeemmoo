package random.uuid;

import java.util.UUID;

public class MainTest {
  public static void main(String[] args) {
    test001();
  }
  public static void test001() {
    String uuid1 = UUID.randomUUID().toString();
    String uuid2 = uuid1.replaceAll("-","");
    System.out.println(uuid1);
    System.out.println(uuid2);
  }
}
