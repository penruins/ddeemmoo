package com.example.springboot0008shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
  /**
   * 用户登录
   * @param username
   * @param password
   * @return
   */
  @RequestMapping("login")
  public String login(String username,String password){
    // 获取当前登录用户
    Subject subject = SecurityUtils.getSubject();

    try {
      // 执行登录操作
      subject.login(new UsernamePasswordToken(username,password));
      // 认证通过后直接跳转到index.jsp
      return "redirect:/index.jsp";
    } catch (UnknownAccountException e) {
      e.printStackTrace();
      System.out.println("用户名错误~");
    } catch (IncorrectCredentialsException e) {
      e.printStackTrace();
      System.out.println("密码错误~");
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 如果认证失败仍然回到登录页面
    return "redirect:/login.jsp";
  }
  @RequestMapping("logout")
  public String logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    // 退出后仍然会到登录页面
    return "redirect:/login.jsp";
  }
}
