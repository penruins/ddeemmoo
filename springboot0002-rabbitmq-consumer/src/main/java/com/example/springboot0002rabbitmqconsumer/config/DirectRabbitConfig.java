package com.example.springboot0002rabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectRabbitConfig {
  @Bean
  public Queue TestDirectQueue() {
    return new Queue("TestDirectQueue", true);
  }

  @Bean
  DirectExchange TestDirectExchange() {
    return new DirectExchange("TestDirectExchange");
  }

  // 绑定 将队列和交换机绑定，并设置用于匹配键：TestDirectRouting
  @Bean
  Binding bindingDirect() {
    return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");

  }
}
