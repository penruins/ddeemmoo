package com.example.springboot0001.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot0001.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {
  @Autowired
  private PeopleMapper peopleMapper;

  @Test
  public void testSelectPage() {
    Page<People> page = new Page<>(1,5);
    peopleMapper.selectPage(page,null);
    page.getRecords().forEach(System.out::println);
  }


}
