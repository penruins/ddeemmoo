package com.example.springboot0003redis;

import com.example.springboot0003redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot0003RedisApplicationTests {
  @Autowired
  private RedisService redisService;

  @Test
  void contextLoads() {
    String penruins = redisService.get("penruins");
    System.out.println(penruins);
  }

}
