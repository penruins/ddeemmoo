package com.example.springboot0001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot0001.entity.People;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PeopleMapper extends BaseMapper<People> {
}
