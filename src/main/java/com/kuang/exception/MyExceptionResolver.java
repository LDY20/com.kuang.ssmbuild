package com.kuang.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.NullCipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    /*
    * 最主要的两个：参数Exception 即异常对象
    *            返回ModelAndView  即跳转到错误视图界面
    * */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        //instanceof是Java中的二元运算符，左边是对象，右边是类；当对象是右边的类或子类所创建对象时，返回true；否则，返回false（注意:左边的对象实例不能是基本数据类型）
        if (ex instanceof ClassCastException){
            modelAndView.addObject("info","类型转换异常");
        }else if (ex instanceof NullPointerException){
            modelAndView.addObject("info","空指针异常");
        }
        modelAndView.setViewName("error");

        return modelAndView;

    }
}
