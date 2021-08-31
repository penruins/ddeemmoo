package consolePrint;

import cn.hutool.core.lang.Console;

/**
 * https://www.hutool.cn/docs/#/core/%E8%AF%AD%E8%A8%80%E7%89%B9%E6%80%A7/%E6%8E%A7%E5%88%B6%E5%8F%B0%E6%89%93%E5%8D%B0%E5%B0%81%E8%A3%85-Console
 *
 */
public class ConsolePrintTest {
  public static void main(String[] args) {
    String[] a = {"abc", "bcd", "cde"};
    Console.log(a);

    Console.log("This is Console log for {}","test");
  }
}
