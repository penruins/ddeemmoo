package com.example.springboot0001.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot0001.entity.People;
import com.example.springboot0001.mapper.PeopleMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("api for people")
@RestController
public class PeopleController {
  @Autowired
  private PeopleMapper peopleMapper;

  /**
   * 返回所有的 people
   *
   * 浏览器会卡死
   * @return
   */
  @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
  public List<People> listUsers() {
    return peopleMapper.selectList(null);
  }
  @RequestMapping(value = "/listUsers/{page}/{size}", method = RequestMethod.GET)
  public List<People> listUsers(@PathVariable long page, @PathVariable long size) {
    Page<People> page_ = new Page<>(page,size);
    peopleMapper.selectPage(page_,null);
    return page_.getRecords();
  }
}
