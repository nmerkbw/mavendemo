package com.example.test.aop.demo4;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class PerformanceImpl implements Performance {
    @Override
    public String perfance() {
        System.err.println("正确的执行了表演");
        return "default";
    }
}
