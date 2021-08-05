package com.example.springboot0001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot0001.mapper")
public class Springboot0001Application {

  public static void main(String[] args) {
    SpringApplication.run(Springboot0001Application.class, args);
  }

}
