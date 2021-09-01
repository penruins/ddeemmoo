import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 这个教程有问题啊
 * [RabbitMQ快速入门Java Demo](https://blog.csdn.net/u011311514/article/details/89524250)
 *
 * 用官网的 tutorial
 *
 * [【译】RabbitMQ教程一](https://www.jianshu.com/p/36a328ff8a6b)
 *
 * RabbitMQ 是一个消息代理：它接收并转发消息。你可以把它当成一个邮局。当你想邮寄信件的时候，你会把信件放在投递箱中，并确信邮递员
 * 最终会将新建送到收件人手里
 *
 * RabbitMQ 与邮局的区别在于：RabbitMQ并不处理纸质信件，而是接接收、存储并转发二进制数据
 *
 * 消息仅仅在不存在的时候才会创建。消息的内容是一个字节数组，所以你可以随意编码
 */
public class RabbitMqMain {
  // 定义队列的名字
  private final static String QUEUE_NAME = "hello";
  public static void main(String[] args) throws Exception{
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUsername("guest");
    factory.setPassword("guest");
    factory.setHost("localhost");
    factory.setPort(5677);
    // Connection 是 socket 连接的抽象，为我们处理了通信协议版本协商以及认证等
    try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      String message = "Hello World!";
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      System.out.println(" [x] Sent " + message);
    }
  }
}
