package io.scanner;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerTest {
  /**
   * 在Java语言中，格式化输入是通过类java.util.Scanner来完成的。默认情况下，Scanner是使用「空白」
   * 作为分隔符将输入分解为标记，然后使用它所提供的不同的next方法将得到的标记转换为不同的类型的值
   *
   * 由于Scanner对象首先跳过输入流开头的所有空白分隔符，然后对输入流中的信息进行检查，直到遇到空白分隔符为止
   * 因此输入数据 this is a test 后面的 is a test 不会显示输出来
   */
  @Test
  public void test() {
    Scanner scanner = new Scanner("this is a test");
    String next = scanner.next();
    System.out.printf("%s", next);
  }


  /**
   * 如何将含有空格的数据输出呢？
   *    这是就需要用Scanner.useDelimiter()方法    delimiter 界定符 分隔符
   *    可以将分隔符修改为「回车」或者其他字符
   */
  @Test
  public void test2() {
    Scanner scanner = new Scanner("this is a test\n").useDelimiter("\n");
    String year = scanner.next();
    System.out.printf("%s",year);
  }

  /**
   * useDelimiter()的第二个测试
   */
  @Test
  public void test3() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Scanner scanner = new Scanner(format.format(new Date())).useDelimiter("\\D");//匹配非数字
    int year = scanner.nextInt();
    int month = scanner.nextInt();
    int day = scanner.nextInt();
    System.out.println(year);
    System.out.println(month);
    System.out.println(day);
  }
}
