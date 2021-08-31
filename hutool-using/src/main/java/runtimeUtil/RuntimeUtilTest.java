package runtimeUtil;

import cn.hutool.core.util.RuntimeUtil;

/**
 * 命令行工具
 */
public class RuntimeUtilTest {
  public static void main(String[] args) {
    String str = RuntimeUtil.execForStr("ipconfig");
    System.out.println(str);

  }
}
