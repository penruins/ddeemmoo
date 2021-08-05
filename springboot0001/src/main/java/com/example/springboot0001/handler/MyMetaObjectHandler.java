package com.example.springboot0001.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    // 这里必须写成驼峰的形式
    this.setInsertFieldValByName("createTime",
      new Date(), metaObject);
    this.setInsertFieldValByName("updateTime",
      new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.setUpdateFieldValByName("updateTime",
      new Date(), metaObject);
  }
}
