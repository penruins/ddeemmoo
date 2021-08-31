package validator;

import cn.hutool.core.lang.Validator;

public class ValidatorTest {
  public static void main(String[] args) {
    boolean isEmail = Validator.isEmail("lx_tdcq_king@icloud.com");
    System.out.println(isEmail);
  }
}
