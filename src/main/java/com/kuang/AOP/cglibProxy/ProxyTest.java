package com.kuang.AOP.cglibProxy;




//此代码是AOP的jdk代理的底层，需要理解和熟悉；一般是动态代理需要Spring去配置

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(final String[] args) {
        final Target target = new Target();//目标对象
        final Advice advice = new Advice();//增强对象

        //返回值 就是动态生成的代理对象  基于cglib
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置父类（目标）
        enhancer.setSuperclass(Target.class);
        //3、设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();//执行前置
                Object invoke = method.invoke(target,args);//执行目标
                advice.afterReturning();//执行后置
                return invoke;
            }
        });
        //4、设置代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
