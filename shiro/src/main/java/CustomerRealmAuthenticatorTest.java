import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class CustomerRealmAuthenticatorTest {
  public static void main(String[] args) {
    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    defaultSecurityManager.setRealm(new CustomerRealm());
    SecurityUtils.setSecurityManager(defaultSecurityManager);
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken("christy","123456");
    try {
      // 登录认证
      subject.login(token);
      System.out.println(subject.isAuthenticated());
    } catch (UnknownAccountException e) {
      e.printStackTrace();
      System.out.println("用户名错误");
    } catch (IncorrectCredentialsException e) {
      e.printStackTrace();
      System.out.println("密码错误");
    }
  }
}
