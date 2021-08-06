package com.example.springboot002;

import com.example.springboot002.websocket.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class Springboot002Application {

  public static void main(String[] args) {
    SpringApplication.run(Springboot002Application.class, args);
  }


}
