package com.example.springboot0001.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
  private int id;
  private String name;
  private int age;
  private String email;
}
