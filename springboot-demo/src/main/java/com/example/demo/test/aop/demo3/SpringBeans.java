package com.example.demo.test.aop.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by louyuting on 17/1/24.
 */
@Configuration
public class SpringBeans {

    @Bean(name = "jack")
    public Chief jack(){
        Chief chief = new Chief();
        chief.setName("jack");
        chief.setOven(oven());
        chief.setCake(cake());
        return chief;
    }

    @Bean(value = "oven")
    public Oven oven() {
        Oven oven = new Oven();
        oven.setName("big oven");
        return oven;
    }

    @Bean
    public Cake cake() {
        Cake cake = new Cake();
        cake.setName("blueberryCheeseCake");
        return cake;
    }

    @Bean
    public Log log() {
        return new Log();
    }
}