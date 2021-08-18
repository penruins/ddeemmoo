package com.example.springboot0001.controller;

import com.example.springboot0001.entity.People;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CommonController {
  @RequestMapping(value = "/getRequestInformation", method = RequestMethod.GET)
  public String listUsers(HttpServletRequest request) {
    System.out.println(request.getAuthType());
    System.out.println(request.getContentLength());
    System.out.println(request.getContextPath());
    return "backend have gotten your request information";
  }

}
