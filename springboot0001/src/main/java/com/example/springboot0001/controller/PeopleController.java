package com.example.springboot0001.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot0001.entity.People;
import com.example.springboot0001.mapper.PeopleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

  @RequestMapping(value = "/count", method = RequestMethod.GET)
  public Long getCount() {
    return peopleMapper.getCount();
  }

  @RequestMapping(value = "/printUserInfo", method = RequestMethod.POST)
  public String login(HttpServletResponse response,
                      @RequestParam(value = "id", required = true) String id,
                      @RequestParam(value = "name", required = true) String name,
                      @RequestParam(value = "age", required = true) String age) {
      System.out.println(id);
    System.out.println();
    return "ok";
  }
}














