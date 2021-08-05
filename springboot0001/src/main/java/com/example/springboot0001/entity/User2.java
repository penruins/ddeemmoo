package com.example.springboot0001.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_user2")
public class User2 {
  private int id;
  private String name;
  private int age;
  private String email;
  /**
   * 数据库中字段名称为 create_time 和 update_time
   * 封装的实体类的变量要用驼峰命名法
   */
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
}
