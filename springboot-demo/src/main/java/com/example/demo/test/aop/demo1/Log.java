package com.example.demo.test.aop.demo1;

/**
 * Created by louyuting on 17/1/20.
 * Log类模拟日志
 */
public class Log {
    public void before() {
        System.out.println("beforeSing");
    }

    public void after() {
        System.out.println("afterSing");
    }
}
