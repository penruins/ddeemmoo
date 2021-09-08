import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomerMD5Realm2 extends AuthorizingRealm {
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  // 认证
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    // 从token中获取用户名
    String principal = (String) token.getPrincipal();
    if("christy".equals(principal)){
      /**
       * 用户名
       * 加密后的密码
       * 随机盐
       * 当前realm的名称
       */
      return new SimpleAuthenticationInfo(principal,
        "41a4e25bcf1272844e38b19047dd68a0",
        ByteSource.Util.bytes("1q2w3e"),
        this.getName());
    }
    return null;
  }
}
