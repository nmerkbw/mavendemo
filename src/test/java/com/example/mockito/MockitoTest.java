package com.example.mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * description Mockito 测试
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 03/07/2017
 *
 * @author louyuting
 * @date 2017/07/03
 */
public class MockitoTest {
    List mockedList;

    @Before
    public void before(){
        mockedList = mock(List.class);
    }


    //验证行为
    @Test
    public void test1() {
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
        mockedList.clear();
    }


    // stubbing
    @Test(expected = RuntimeException.class)
    public void test2(){
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedList.get(0));
        String res = (String)verify(mockedList).get(0);
        System.err.println(res);
        System.out.println(mockedList.get(1));
        System.out.println(mockedList.get(999));
        mockedList.clear();
    }


    // 参数匹配器
    @Test
    public void test3(){
        // stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");
        // stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        //when(mockedList.contains(argThat( any() ))).thenReturn(true);
        // following prints "element"
        System.out.println(mockedList.get(999));
        // you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        mockedList.add("asdfghjkl");
        // arguement matchers can also be written as java8 lambda
        verify(mockedList).add(argThat( (String str) -> str.length() > 5) );
    }


    // 参数匹配器 2
    @Test
    public void test4(){
        when(mockedList.addAll( argThat(new ListOfTwoElements()))).thenReturn(true);
        mockedList.addAll(Arrays.asList("one", "two"));
        verify(mockedList).addAll(argThat(new ListOfTwoElements()));
        // java 8
        verify(mockedList).addAll(argThat(list -> {
            if (list==null)
                return false;
            return list.size()==2;
        }));
    }










}
