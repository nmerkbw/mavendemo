package com.example.demo;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class SpringbootDemoApplication {

    @GetMapping(value = "/test")
    public User hello(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
        User user = new User();
        user.setId(123456789l);
        user.setName("louyuting");
        String res = JSON.toJSONString(user);

        // 模拟数据库的阻塞IO操作：延时10ms
        TimeUnit.MILLISECONDS.sleep(10l);

        System.out.println(res);
        //log.info("debug输出信息{}", res);
        return user;
    }


	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
