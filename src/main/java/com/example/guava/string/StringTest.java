package com.example.guava.string;

import javax.sound.midi.Soundbank;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/6
 */
public class StringTest {

    // apache commons lang3 组件
    @Test
    public void test1(){
        // null或则长度非0则判断为null
        System.out.println(StringUtils.isEmpty(null));
        // null 或则 长度为0 都判定为empty
        int[] array = {};
        System.out.println(ArrayUtils.isEmpty(array));

        System.out.println(SystemUtils.JAVA_VM_NAME);
    }
}
