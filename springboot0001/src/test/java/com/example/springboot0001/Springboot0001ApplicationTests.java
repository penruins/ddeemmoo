package com.example.springboot0001;

import com.example.springboot0001.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.springboot0001.entity.User;

import java.util.List;

@SpringBootTest
class Springboot0001ApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  void contextLoads() {
  }

  @Test
  public void testSelect() {
    System.out.println("----- selectAll method test -----");
    List<User> userList = userMapper.selectList(null);
    for(User user : userList) {
      System.out.println(user);
    }
  }

}
