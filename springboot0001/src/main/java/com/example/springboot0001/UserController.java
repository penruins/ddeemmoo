package com.example.springboot0001;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @RequestMapping("/addUser")
  public void addUser(@RequestBody UserResponse userResponse) {
    System.out.println(userResponse.getUser());
  }
}
