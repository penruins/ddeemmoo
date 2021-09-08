import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class Main {
  public static void main(String[] args) {
    DefaultSecurityManager securityManager = new DefaultSecurityManager();
    securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
    SecurityUtils.setSecurityManager(securityManager);
    Subject subject = SecurityUtils.getSubject();
    AuthenticationToken token = new UsernamePasswordToken("christy","123456");

    try {
      System.out.println("认证状态：" + subject.isAuthenticated());
      subject.login(token);
      System.out.println("认证状态：" + subject.isAuthenticated());
    } catch (UnknownAccountException e) {
      e.printStackTrace();
      System.out.println("认证失败：用户不存在！");
    } catch (IncorrectCredentialsException e) {
      e.printStackTrace();
      System.out.println("认证失败：密码不正确");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
