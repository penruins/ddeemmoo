package com.example.springboot002.timer;

import com.example.springboot002.websocket.WebSocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class SendSchedule {

  @Scheduled(cron = "*/5 * * * * ?")
  public void execute() {
    try {
      WebSocketServer.sendMessage((new Date().toString()));
      System.out.println("hhhhhh");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
