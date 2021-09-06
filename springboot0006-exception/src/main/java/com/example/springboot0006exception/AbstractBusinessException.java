package com.example.springboot0006exception;

/**
 * [第四节 SpringBoot处理异常（异常设计的思考）](https://zhoutianyu.blog.csdn.net/article/details/100669352)
 */
public abstract class AbstractBusinessException extends RuntimeException {

  private int code;

  public AbstractBusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public AbstractBusinessException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
