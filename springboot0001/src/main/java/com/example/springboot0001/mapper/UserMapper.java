package com.example.springboot0001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot0001.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
