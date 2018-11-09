package com.example.springaop.demo_jdk_01;

import com.example.demo.model.Equipmentinfolist;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 13:58
 **/


public class Test {
    public static void main(String[] args){
        long start = System.nanoTime();

        CalcService target = new CalcServiceImpl();
        CalcHandler handler = new CalcHandler(target);
        CalcService calcProxy = (CalcService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        System.out.println("创建时间：" + (System.nanoTime()-start));

        start = System.nanoTime();
        calcProxy.add(2, 3);
        System.out.println("执行时间：" + (System.nanoTime()-start));

    }
}
