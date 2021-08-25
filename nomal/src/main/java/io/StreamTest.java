package io;

import org.junit.Test;

import java.io.*;

/**
 * 流：代表任何有能力产出数据的数据源对象或者是有能力接收数据的接收端对象 Thinking in Java
 * 流的本质：数据传输，根据数据传输特性将流抽象为各种类，方便更直观的进行数据操作
 * 作用：为数据源和目的地建立一个输送通道
 *
 * Java IO所采用的模型
 *    Java的IO模型设计非常优秀它使用Decorator模式 即装饰者模式，按功能划分Stream，你可以动态装配这些Stream，以便获得你需要的功能
 *    例如，你需要一个具有缓冲的文件输入流，则应当组合使用FileInputStream和BufferedInputStream
 *
 *
 * 输入流
 * 输出流
 *
 * 字节流
 * 字符流
 *
 * 节点流：以从或向一个特定的地方（或节点）读写数据。如FileInputStream
 * 处理流：是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。如BufferedReader。处理流的构造方法总是要带一个其他的流对象做参数
 *        一个流对象经过其他流的多次包装
 *
 * 4个基本的抽象流流行，所有的流都继承这四个
 *
 *    字节输入/输出流 InputStream OutputStream
 *    字符输入/输出流 Reader Writer
 *
 *
 *
 *
 * 字符流的由来：Java中字符是采用Unicode标准，一个字符是16位，即一个字符使用两个字节来表示。为此，Java中引入了处理字符的流
 *             因为数据编码的不同，而有了对字符进行高效操作的流对象。本质其实就是基于字节流读取时，去查了指定的码表
 *
 *
 *  IO流的特性
 *      先进先出
 *      顺序读取
 *      只读或只写：每个流只能是输入流或输出流的一种，不能同时具备两个功能，输入流只能进行读操作，对输出流只能进行写操作
 *                在一个数据传输通道中，如果既要写入数据，又要读取数据，则要分别提供两个流
 *
 *
 *
 *  InputStream
 *      ByteArrayInputStream 字节数组输入流，该类的功能就是从字节数组中进行以字节为单位的读取，也就是将资源文件都以字节的形式存入到该类的字节数组中去
 *      PipedInputStream 管道字节输入流，它和PipedOutputStream一起使用，能实现多进程间的管道通信
 *      FilterInputStream 装饰者模式处于装饰者，具体的装饰者都要继承它，所以在该类的子类下都是用来装饰别的流的，也就是处理类
 *      BufferedInputStream 缓冲流，对处理流进行装饰，增强，内部会有一个缓冲区，用来存放字节，每次都是将缓存区存满然后发送，而不是一个字节或两个字节这样发送。效率更高
 *      DataInputStream 数据输入流，它是用来装饰其他输入流，它允许应用程序以机器无关方式从底层输入流中读取基本Java数据类型
 *      FileInputStream 文件输入流 它通常用于对文件进行读取操作
 *      ObjectInputStream 对象输入流，用来提供对基本数据或对象的持久存储，也就是能直接传输对象（反序列化中使用）
 *
 *
 *  Reader
 *      CharReader、StringReader是两种基本的介质流，它们分别将Char数组、String中读取数据。PipedReader是从与其他线程共用的管道中读取数据
 *      BufferedReader 很明显就是一个装饰器，它和其子类负责装饰其他Reader对象
 *      FilterReader 是所有自定义具体装饰流的父类，其子类PushbackReader对Reader对象进行装饰，会增加一个行号
 *      InputStreamReader 一个连接字节流和字符流的桥梁，它将字节流转变为字符流。FileReader可以说是一个达到此功能、常用的工具类
 *
 *
 *
 *  字符流与字节流转换
 *      转换流的作用，文本文件在硬盘中以字节流的形式存储的，通过InputStreamReader读取转化后字符流给程序处理，程序处理的字符流通过OutputStreamWriter转换为字节流保存
 *
 *
 *  字节流和字符流的区别
 *      字节流没有缓冲区，是直接输出的，而字符流是输出到缓冲区的。因此在输出时，字节流不调用close()方法时，信息已经输出了，而字符流只有在调用close()方法关闭缓冲区时，
 *      信息才输出。要想字符流在未关闭时输出信息，则需要手动调用flush()方法
 *
 *
 *  只要是处理纯文本数据，就优先考虑使用字符流。除此之外都使用字节流
 */
public class StreamTest {
  /**
   * ByteArrayInputStream测试
   * @throws IOException
   */
  @Test
  public void test() throws IOException {
    InputStream in = new ByteArrayInputStream("you don't give up then there's no limiltation.".getBytes());
    int c = -1;
    while((c=in.read()) != -1) {
      System.out.print((char) c);
    }
  }

  /**
   * InputStream 和 InputStreamReader 测试
   */
  @Test
  public void test2() {
    InputStream in = new ByteArrayInputStream("他们不热衷于改造世界，他们只想理解他们所赞佩的自然之秩序".getBytes());
    Reader is = new InputStreamReader(in);
  }
}














