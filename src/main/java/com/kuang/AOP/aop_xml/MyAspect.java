package com.kuang.AOP.aop_xml;

import org.aspectj.lang.ProceedingJoinPoint;

//切面类
public class MyAspect {
    public void  before1(){
        System.out.println("前置增强。。。");
    }

    public void  after1(){
        System.out.println("前置增强。。。");
    }

    //Proceeding JoinPoint：正在执行的连接点===即切点
    public Object around1(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置增强。。。");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后置增强。。。");
        return proceed;
    }

    public void throwing1(){
        System.out.println("异常增强。。。");
    }

    //无论有没有异常都执行
    public void after2(){
        System.out.println("最终增强。。。");
    }
}
