package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo01 {
  /**
   * 输出来的结果怎么是乱码?
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    File f = new File("d:" + File.separator + "test.txt");
    RandomAccessFile randomAccessFile = null;
    randomAccessFile = new RandomAccessFile(f, "rw");
    String name = null;
    int age = 0;
    name = "zhangsan"; // 字符串长度为8
    age = 30; // 数字的长度为4
    randomAccessFile.writeBytes(name); // 将姓名写入文件之中
    randomAccessFile.writeInt(age); // 将年龄写入文件之中
    name = "lisi    "; // 字符串长度为8
    age = 31; // 数字的长度为4
    randomAccessFile.writeBytes(name); // 将姓名写入文件之中
    randomAccessFile.writeInt(age); // 将年龄写入文件之中
    name = "wangwu  "; // 字符串长度为8
    age = 32; // 数字的长度为4
    randomAccessFile.writeBytes(name); // 将姓名写入文件之中
    randomAccessFile.writeInt(age); // 将年龄写入文件之中
    randomAccessFile.close(); // 关闭
  }
}
