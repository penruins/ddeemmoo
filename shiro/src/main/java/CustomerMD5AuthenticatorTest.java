import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

public class CustomerMD5AuthenticatorTest {
  public static void main(String[] args) {
    // 创建SecurityManager
    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
    // 设置自定义realm
    CustomerMD5Realm realm = new CustomerMD5Realm();
    // 为realm设置凭证匹配器
    HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
    // 设置加密算法
    credentialsMatcher.setHashAlgorithmName("md5");
    // 设置hash次数
    credentialsMatcher.setHashIterations(1024);
    realm.setCredentialsMatcher(credentialsMatcher);
    defaultSecurityManager.setRealm(realm);
    // 设置安全工具类
    SecurityUtils.setSecurityManager(defaultSecurityManager);
    // 通过安全工具类获取subject
    Subject subject = SecurityUtils.getSubject();
    // 创建token
    UsernamePasswordToken token = new UsernamePasswordToken("christy", "123456");
    try {
      // 登录认证
      subject.login(token);
      System.out.println("认证成功");
    } catch (UnknownAccountException e) {
      e.printStackTrace();
      System.out.println("用户名错误");
    } catch (IncorrectCredentialsException e) {
      e.printStackTrace();
      System.out.println("密码错误");
    }
  }
}
