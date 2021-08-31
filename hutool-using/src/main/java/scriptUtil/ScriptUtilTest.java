package scriptUtil;

import cn.hutool.script.ScriptUtil;

import javax.script.CompiledScript;
import javax.script.ScriptException;


public class ScriptUtilTest {
  private static final String script = "print('Script test!')";
  public static void main(String[] args) {
    test002();
  }
  public static void test001() {
    ScriptUtil.eval(script);
  }
  public static void test002() {
    CompiledScript script = ScriptUtil.compile("print('Script test!')");
    try {
      script.eval();
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }
}
