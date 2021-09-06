package com.example.springboot0006exception;

import lombok.Data;

/**
 * 我们可以定义一个错误响应对象 Response 对象。因为前端不希望得到的是一个错误对象
 * 他们希望得到的是一个封装后的响应
 *
 *
 */
@Data
public class ExceptionResponse {
  private int code;
  private String message;

  /**
   * 在下面的代码中，因为我们面向接口编程，首先判断异常的分类。使用 `instance` 关键字来判断具体异常来自哪个模块
   * 即使这个异常实现类还没有定义，但是只要是继承 `AbstractBusinessException`, 都能进入我们的异常处理
   *    为什么这里是面向接口编程
   * @param exception
   */
  public ExceptionResponse(Exception exception) {
    if(exception instanceof AbstractBusinessException) {
      this.code = ((AbstractBusinessException) exception).getCode();
      this.message = exception.getMessage();
      return;
    }

    //todo : add other abstract exception type

    // here is default code and message
    this.code = 500;
    this.message = "Server internal error";

  }

}
