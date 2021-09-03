package com.example.springboot0003redis.service;

public interface RedisService {
  void set(String key, String value);
  String get(String key);
  // 设置超期时间
  boolean expire(String key, long expire);
  void remove(String key);
  // 自增操作
  Long increment(String key, long delta);
}
