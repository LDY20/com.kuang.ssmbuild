package com.kuang.AOP.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//此代码是AOP的jdk代理的底层，需要理解和熟悉；一般是动态代理需要Spring去配置

public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();//目标对象
        final Advice advice = new Advice();//增强对象

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance( //jdk代理中，返回值必须用接口切接收它，因为其返回值就是动态生成的代理对象；cglib用目标对象去接收
                target.getClass().getClassLoader(), //获取目标对象类加载器
                target.getClass().getInterfaces(), //目标对象实现的接口列表
                new InvocationHandler() { //调用代理对象的额任何方法，实际是执行invocationHandler中的invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*invoke三个参数：
                        proxy：就是代理对象，newProxyInstance方法的返回对象
                        method：调用的方法
                        args: 方法中的参数*/

                        advice.before();//前置增强
                        Object invoke1 = method.invoke(target,args);//执行目标方法（上面的invoke和这个不一样，上面是指动态代理中的invoke，这个是反射里的invoke），此方法里第一个参数是目标对象，第二个参数指实际参数
                        advice.afterReturning();//后置增强

                        return invoke1;

                    }
                }
        );

        //调用代理对象的方法
        proxy.save();
    }
}
