package com.example.springboot0006exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  // 处理自定义的业务异常
  @ExceptionHandler(value = BizException.class)
  @ResponseBody
  public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e) {
    log.error("发生业务异常！ 原因是：{}",e.getErrorMsg());
    return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
  }

  // 处理空指针的异常
}
