package random;

import java.util.ArrayList;
import java.util.List;

public class NameRandom {
  public static void main(String[] args) {
    randomNames().forEach(System.out::println);

  }
  public static List<String> randomNames() {
    List<String> result = new ArrayList<>();
    String[] lastName = {"刘","李","王","文","谢",
                          "曹","黄","董","杨","张",
                          "吴","梁","盛","韩","彭",
                          "许","白","何","樊","丁"};
    String[] firstName = {"翔","颖","明辉","承学","喜庆",
                          "继科","贵阳","志云","巧","君",
                          "成","晓庆","汉柏","玉峰","琼仙",
                          "紫薇","伯伟","靖翔","泰","恒伟"};
    for(int i=0;i<lastName.length;i++) {
      for(int j=0;j<firstName.length;j++) {
        String fullName = lastName[i] + firstName[j];
        result.add(fullName);
      }
    }
    return result;
  }
}
