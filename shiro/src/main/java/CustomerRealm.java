import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义 realm
 */
public class CustomerRealm extends AuthorizingRealm {
  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  // 认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    // 在 token 中获取用户名
    String principal = (String) authenticationToken.getPrincipal();
    System.out.println(principal);
    if("christy".equals(principal)) {
      // 参数说明 用户名 密码 当前realm的名字
      SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(principal,"123456", this.getName());
      return simpleAuthenticationInfo;
    }
    return null;
  }
}
