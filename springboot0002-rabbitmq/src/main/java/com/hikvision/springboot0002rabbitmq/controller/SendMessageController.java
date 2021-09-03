package com.hikvision.springboot0002rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SendMessageController {
  // 使用 `RabbitTemplate`, 这提供了接收/发送等等方法
  @Autowired
  RabbitTemplate rabbitTemplate;

  @GetMapping("/sendDirectMessage")
  public String sendDirectMessage() {
    String messageId = String.valueOf(UUID.randomUUID());
    String messageData = "test message, hello!";
    String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    Map<String,Object> map = new HashMap<>();
    map.put("messageId", messageId);
    map.put("messageData", messageData);
    map.put("createTime",createTime);

    // 将消息携带绑定键值: TestDirectRouting, 发送到交换机 TestDirectExchange
    rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting", map);
    return "ok";
  }
}
