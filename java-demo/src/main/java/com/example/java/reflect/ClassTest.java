package com.example.java.reflect;

import com.example.java.reflect.dependency.First;

/**
 * Created by louyuting on 17/1/14.
 */
public class ClassTest {

    @org.junit.Test
    public void test1() throws ClassNotFoundException {
        Class first1 = First.class;//没有加载类
        System.out.println("first1:" + first1);
    }

    @org.junit.Test
    public void test2() throws ClassNotFoundException {
        Class first2 = Class.forName("com.example.java.reflect.First");//加载类到JVM
        System.out.println("first2:" + first2);
    }

    @org.junit.Test
    public void test3() throws ClassNotFoundException {
        Class<?> first3 = new First().getClass();//加载类到JVM内存并把非静态域参数初始化.
        System.out.println("first3:" + first3);
    }

}











