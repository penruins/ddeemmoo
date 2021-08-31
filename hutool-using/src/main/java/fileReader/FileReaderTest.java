package fileReader;

import cn.hutool.core.io.file.FileReader;

/**
 * https://www.hutool.cn/docs/#/core/IO/%E6%96%87%E4%BB%B6/%E6%96%87%E4%BB%B6%E8%AF%BB%E5%8F%96-FileReader
 *
 */
public class FileReaderTest {
  private static String path = "C:\\Users\\liuxiang37\\AppData\\Local\\Packages\\CanonicalGroupLimited.Ubuntu18.04onWindows_79rhkp1fndgsc\\LocalState\\rootfs\\home\\penruins\\my-docs5\\docs\\index.md";
  public static void main(String[] args) {
    FileReader fileReader = new FileReader(path);
    String content = fileReader.readString();
    System.out.println(content);
  }
}
