package com.example.springboot0001;

import com.example.springboot0001.entity.User2;
import com.example.springboot0001.mapper.UserMapper;
import com.example.springboot0001.mapper.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.springboot0001.entity.User;

import java.util.Date;
import java.util.List;

@SpringBootTest
class Springboot0001ApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserMapper2 userMapper2;

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
  @Test
  public void testInsert() {
    User2 user = new User2();
    user.setId(2);
    user.setName("penruins");
    user.setAge(23);
    user.setEmail("lx_tdcq_king@icloud.com");
    user.setCreateTime(new Date());
    user.setUpdateTime(new Date());
    if(userMapper2.insert(user) == 1) {
      userMapper2.selectList(null)
        .forEach(System.out::println);
    } else {
      System.out.println("添加数据失败");
    }
  }

  @Test
  public void testInsert2() {
    User2 user = new User2();
    user.setId(6);
    user.setName("penruins");
    user.setAge(23);
    user.setEmail("lx_tdcq_king@icloud.com");
    // `createTime` 和 `updateTime` 没有赋值
    if(userMapper2.insert(user) == 1) {
      userMapper2.selectList(null)
        .forEach(System.out::println);
    } else {
      System.out.println("添加数据失败");
    }
  }
}

















