package com.example.java;

import java.util.Objects;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/14
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Objects.equals("test", "test"));
    }

    @org.junit.Test
    public void test_1(){
        Integer a = new Integer(23);
        Integer b = new Integer(23);
        System.out.println(a.equals(b));
        System.out.println(Objects.equals(a, b));
    }
}
