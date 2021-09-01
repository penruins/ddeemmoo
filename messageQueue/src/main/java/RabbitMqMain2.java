import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * 代码是官网的 tutorial
 *
 * 运行这个程序，它会一直挂着
 *
 * 消费者从 RabbitMQ 中取出消息。不同于发布者只发送一条消息就退出，这里我们让消费者一直监听消息，并把接收到的消息打印出来
 */
public class RabbitMqMain2 {
  private final static String QUEUE_NAME = "hello";
  public static void main(String[] args) throws Exception{
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    factory.setPort(5677);
    factory.setUsername("guest");
    factory.setPassword("guest");
    Connection connection = factory.newConnection();

    Channel channel = connection.createChannel();
    // 消费者同样声明了队列。这是因为，我们可能在启动生产者之前启动了消费者应用，我们想确保在从一个队列消费消息之前，这个队列是存在的
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CRTL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
      String message = new String(delivery.getBody(), "UTF-8");
      System.out.println(" [x] Received " + message);
    };
    channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumeTag -> { });
  }
}
