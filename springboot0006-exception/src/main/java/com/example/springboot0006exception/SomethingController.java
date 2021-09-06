package com.example.springboot0006exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomethingController {
  @GetMapping(value = "/exception/test")
  public void function(String paramType) {
    throw new FieldInvalidException("param type is null");
  }
}
