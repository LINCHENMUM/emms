package com.zssy.sbwx.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SecurityFilter extends HttpServlet implements Filter {
 private static final long serialVersionUID = 1L;

 public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
 throws IOException, ServletException {
     HttpServletRequest request=(HttpServletRequest)arg0;   
     HttpServletResponse response  =(HttpServletResponse) arg1;    
     HttpSession session = request.getSession(true);     
     //String usercode = (String) request.getRemoteUser();// 登录人
     String username = (String)session.getAttribute("username");//登录人角色
     //System.out.println(username);
     String url=request.getRequestURI();   
     if(/*usercode==null || "".equals(usercode) || */username == null || "".equals(username)
    		 ||"null".equals(username)) {      
             //判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转   
             if(url!=null && !url.equals("") && ( url.indexOf("Login")<0 && url.indexOf("login")<0 )) {   
                 response.sendRedirect(request.getContextPath() + "/login.jsp");   
                 return ;   
             }              
         }   
            arg2.doFilter(arg0, arg1);   
            return;   
 }
 public void init(FilterConfig arg0) throws ServletException {
 }

}