package com.example.springboot0001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot0001.entity.User2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 extends BaseMapper<User2> {
}
