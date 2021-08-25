package regex;

import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    String content = "I am noob from runoob.com";
    String pattern = ".*runoob.*";
    boolean isMatch = Pattern.matches(pattern, content);
    System.out.println("字符串是否包含了 'runoob' 子字符串？   " + isMatch);
  }
}
