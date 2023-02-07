package com.kuang.AOP.aop_xml;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
        int a = 1/0;  //测试异常通知作的假设
    }
}
