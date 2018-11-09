package com.example.springaop.demo_cglib_01;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 14:16
 **/


import java.lang.reflect.Method;

//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CalcProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz); // 设置需要被代理的类 target
        enhancer.setCallback(this);
        return enhancer.create(); // 通过字节码技术动态创建子类
    }

    // 拦截父类所有方法的调用
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("*******调用方法前执行代码******");
        Object result = proxy.invokeSuper(obj, args); // 通过代理类调用父类中的方法
        System.out.println("*******调用方法后执行代码******");
        return result;
    }

}