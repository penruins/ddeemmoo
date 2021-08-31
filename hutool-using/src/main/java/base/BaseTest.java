package base;

import cn.hutool.core.codec.Base62;

/**
 *
 * https://www.hutool.cn/docs/#/core/Codec%E7%BC%96%E7%A0%81/Base62%E7%BC%96%E7%A0%81%E8%A7%A3%E7%A0%81-Base62
 */
public class BaseTest {
  private static final String motto = "You dont give up, then there's no limitation.";
  public static void main(String[] args) {
    test001();
  }

  /**
   * Base62编码是由10个数字、26个大写英文字母和26个小写英文字母组成，多用于安全领域和短URL生成。
   */
  public static void test001() {
    String encode = Base62.encode(motto);
    System.out.println(encode);
    String decodeStr = Base62.decodeStr(encode);
    System.out.println(decodeStr);
  }
}
