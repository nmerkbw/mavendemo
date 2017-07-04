package com.example.mockito;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 04/07/2017
 */
public class BaseTestCase {
    @Before
    public void initMocks(){
        // 初始化mock 对象
        MockitoAnnotations.initMocks(this);
    }
}
