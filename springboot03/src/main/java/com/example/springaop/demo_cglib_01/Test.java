package com.example.springaop.demo_cglib_01;

import com.example.springaop.demo_jdk_01.CalcServiceImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 14:18
 **/


public class Test {
    public static void main(String[] args) {
        CalcProxy proxy = new CalcProxy();
        CalcServiceImpl calcImpl = (CalcServiceImpl)proxy.getProxy(CalcServiceImpl.class);
        calcImpl.add(2, 3);

//        Map<Map<Map<String,String>,String>,String> AA=new HashMap<>();
    }
}
