package com.example.springboot0001.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_people")
public class People {
  private int id;
  private String name;
  private int age;
}
