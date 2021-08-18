package com.example.springboot0001.controller;

import com.example.springboot0001.UserResponse;
import com.example.springboot0001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/addUser", method = RequestMethod.GET)
  public void addUser(@RequestBody UserResponse userResponse) {
    System.out.println(userResponse.getUser());
  }
  @RequestMapping(value = "/addUser2", method = RequestMethod.GET)
  public void addUser2(@RequestBody String userResponse) {
    userService.addUser(userResponse);
  }
}
