package com.example.java.reflect;

import com.example.java.reflect.dependency.Second;
import com.example.java.reflect.dependency.Third;

/**
 * Created by louyuting on 17/1/15.
 */
public class ClassTest2 {
    public static void main(String[] args) {
        try {
            Class secondA = Class.forName("com.example.java.reflect.Second");
            secondA = Third.class;
            Class<Second> SecondB = (Class<Second>) Class.forName("com.example.java.reflect.Second");
            //SecondB = Third.class;//error
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @org.junit.Test
    public void test1(){
        try {
            Class<?> secondA = Class.forName("com.example.java.reflect.Second");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
