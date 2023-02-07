package com.kuang.AOP.AopAnno;


import org.springframework.stereotype.Component;

@Component("target1")   //将目标类交由Spring实例化
public class Target1 implements TargetInterface1 {
    public void save() {
        System.out.println("save running...");
        int a = 1/0;  //测试异常通知作的假设
    }
}
