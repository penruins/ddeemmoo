import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 这个教程有问题啊
 * [RabbitMQ快速入门Java Demo](https://blog.csdn.net/u011311514/article/details/89524250)
 *
 * 用官网的 tutorial
 */
public class RabbitMqMain {
  private final static String QUEUE_NAME = "hello";
  public static void main(String[] args) throws Exception{
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUsername("guest");
    factory.setPassword("guest");
    factory.setHost("localhost");
    factory.setPort(5677);
    try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
      channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      String message = "Hello World!";
      channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
      System.out.println(" [x] Sent " + message);
    }
  }
}
