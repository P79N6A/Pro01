package com.example.springaop.demo_jdk_01;

/**
 * @author akoasm hzd
 * @since date: 2018/10/21 time: 13:55
 **/


public class CalcServiceImpl implements CalcService {
    @Override
    public void add(int x, int y) {
        System.out.println("结果为" + (x + y));
    }
}
