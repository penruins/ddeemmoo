package com.example.springboot0001.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot0001.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PeopleMapper extends BaseMapper<People> {
  @Select("select count(*) from t_people")
  Long getCount();
}
