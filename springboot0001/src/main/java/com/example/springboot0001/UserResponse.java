package com.example.springboot0001;

import lombok.Data;

@Data
public class UserResponse {
  private String code;
  private User user;
  private String msg;
}

