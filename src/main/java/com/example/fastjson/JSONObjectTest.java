package com.example.fastjson;

import com.alibaba.fastjson.JSONObject;

import com.example.fastjson.domain.Info;
import com.example.fastjson.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/21
 */
public class JSONObjectTest {
    @Test
    public void test_JSONObject_1(){
        JSONObject json = new JSONObject();
        json.put("success", true);
        json.put("errorCode", 1);
        Info info = new Info();
        info.setAddressId("12324357689");
        info.setContactName("楼听");
        info.setPhone("12345697564");
        json.put("data", info);
        System.out.println(json.toJSONString());
        System.out.println(json.toString());
    }
}
