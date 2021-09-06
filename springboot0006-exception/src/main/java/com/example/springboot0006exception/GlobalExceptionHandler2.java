package com.example.springboot0006exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

//

/**
 * 编写一个用于捕获全局异常的类
 *
 * 处理异常的最终目的就是封装 code 与 message 给前端同事
 */
@RestControllerAdvice
public class GlobalExceptionHandler2 {

  /**
   * 处理所有异常
   *
   * @param exception 异常对象
   * @return 异常标准响应
   */
  public ExceptionResponse handlerException(Exception exception) {
    return new ExceptionResponse(exception);
  }
}
