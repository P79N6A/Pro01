package com.example.springaop.demo_jdk_01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 13:56
 **/


public class CalcHandler implements InvocationHandler {
    public Object target;


    public CalcHandler(Object target){
        this.target = target;
    }

    /**
     * 实现接口的方法
     * @param proxy 最终生成的代理实例
     * @param method 被代理目标（也就是target)的某个具体方法
     * @param args   某个具体方法的入参参数
     * @return Object 方法返回的值*/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*******调用方法前执行代码******");
        Object obj = method.invoke(this.target, args);
        System.out.println("*******调用方法后执行代码******");
        return  obj;
    }
}
