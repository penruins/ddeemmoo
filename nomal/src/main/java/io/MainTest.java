package io;

import java.io.File;

public class MainTest {

  private static final String path001 = "/Users/penruins/Desktop/code/JDBCDemo/src";
  private static final String path_project = "C:\\Users\\liuxiang37\\repository\\javademo";
  private static final String path_project_src = "C:\\Users\\liuxiang37\\IdeaProjects\\ddeemmoo\\nomal\\src";


  public static void main(String[] args) {
    test001();
  }

  /**
   * 判断一个文件是否存在
   */
  public static void test001() {
    // 可以获得跟目录下的文件
    File file = new File("./b.properties");
    System.out.println(file.exists());
  }

  /**
   * 打印目录树状图结构
   */

  public static void test002() {
    File f = new File(path_project_src);
    printFile(f,0);

  }

  public static void printFile(File file, int level) {
    for(int i=0;i<level;i++) {
      System.out.print("--");
    }
    System.out.println(file.getName());
    if(file.isDirectory()) {
      File[] files = file.listFiles();
      for(File temp : files) {
        printFile(temp,level+1);
      }
    }
  }

}
