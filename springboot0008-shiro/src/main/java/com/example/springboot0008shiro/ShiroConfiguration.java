package com.example.springboot0008shiro;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
  @Bean
  public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

    Map<String,String> map = new HashMap<String,String>();
    map.put("/index.jsp","authc"); // authc 请求这个资源需要认证和授权
    map.put("/user/login","anon");  // anon 设置为公共资源，放行要注意anon和authc的顺序

    // 默认认证界面路径
    shiroFilterFactoryBean.setLoginUrl("/login.jsp");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

    return shiroFilterFactoryBean;
  }
  //2.创建安全管理器
  @Bean
  public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
    DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
    //给安全管理器设置
    defaultWebSecurityManager.setRealm(realm);

    return defaultWebSecurityManager;
  }

  //3.创建自定义realm
  @Bean
  public Realm getRealm(){
    CustomerRealm customerRealm = new CustomerRealm();
    return customerRealm;
  }
}
