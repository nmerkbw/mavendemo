package com.example.demo.test.aop.demo3;

/**
 * Created by louyuting on 17/1/20.
 * 注入属性,记得属性必须要写setter方法  不然就会抛出异常,注入失败.
 */
public class Cake {
    public Cake() {
    }

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
