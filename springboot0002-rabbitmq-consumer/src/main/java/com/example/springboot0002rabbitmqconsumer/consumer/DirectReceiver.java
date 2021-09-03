package com.example.springboot0002rabbitmqconsumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {
  @RabbitHandler
  public void process(Map testMessage) {
    System.out.println("DirectReceiver 消费者收到消息 ： " + testMessage.toString());
  }
}
