import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * 代码是官网的 tutorial
 *
 * 运行这个程序，它会一直挂着
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
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CRTL+C");

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
      String message = new String(delivery.getBody(), "UTF-8");
      System.out.println(" [x] Received " + message);
    };
    channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumeTag -> { });
  }
}
