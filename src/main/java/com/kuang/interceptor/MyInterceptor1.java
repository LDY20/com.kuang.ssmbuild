package com.kuang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    //在目标方法执行之前  执行  (常用)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
        //return true;//若是false,则不通过；true则通过

        String lll = request.getParameter("lll");//request获得参数
        if ("yes".equals(lll)){ //这里如果是做登录拦截器，则路径相等，则通过，正常访问
            return true;
        }else {
            request.getRequestDispatcher("xxx.jsp").forward(request,response); //不通过则返回到某个界面
            return false;

        }
    }

    //在目标方法执行之后，视图对象返回之前  执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //自行设置模型数据（当然也可以自行设置视图）；这样设置之后，数据和界面或直接从这里展示，前面的数据和界面不走了，因为这里是postHandle
        modelAndView.addObject("aaa","fff");
        System.out.println("postHandle....");
    }

    //在流程都执行之后再执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}


//写好拦截器interceptor类后，在spring-mvc.xml中做相应的配置