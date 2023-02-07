package com.kuang.AOP.AopAnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//切面类

@Component("myAspect1")
@Aspect   //标注当前类MyAspect类是一个切面类
public class MyAspect1 {

    @Before("execution(* com.kuang.AOP..MyAspect1.*(..))")
    public void  before1(){
        System.out.println("前置增强。。。");
    }

    @AfterReturning("pointcut()")
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

    @Pointcut("MyAspect1.pointcut()")
    public void throwing1(){
        System.out.println("异常增强。。。");
    }

    //无论有没有异常都执行
    @Pointcut("pointcut()")
    public void after2(){
        System.out.println("最终增强。。。");
    }

    //基于注解的aop----切点表达式的抽取
    @Pointcut("execution(* com.kuang.AOP..MyAspect1.*(..))")
    public void pointcut(){}

}
