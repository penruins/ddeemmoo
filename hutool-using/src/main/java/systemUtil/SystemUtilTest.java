package systemUtil;

import cn.hutool.system.SystemUtil;

public class SystemUtilTest {
  public static void main(String[] args) {
    System.out.println(SystemUtil.getJvmInfo());
    System.out.println(SystemUtil.getJavaInfo());
    System.out.println(SystemUtil.getJavaRuntimeInfo());
    System.out.println(SystemUtil.getOsInfo());
    System.out.println(SystemUtil.getUserInfo());
    System.out.println(SystemUtil.getHostInfo());
    System.out.println(SystemUtil.getRuntimeInfo());
  }
}
