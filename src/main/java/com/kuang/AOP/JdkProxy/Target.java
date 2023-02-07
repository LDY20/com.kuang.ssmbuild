package com.kuang.AOP.JdkProxy;

public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
