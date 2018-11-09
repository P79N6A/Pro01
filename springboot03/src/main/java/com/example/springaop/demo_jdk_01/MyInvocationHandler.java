package com.example.springaop.demo_jdk_01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 15:43
 **/


public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
