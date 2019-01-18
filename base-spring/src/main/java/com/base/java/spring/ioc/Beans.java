package com.base.java.spring.ioc;

import com.base.java.spring.ioc.beanno.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解直接引入Bean
 * @author tangwei
 * @date 2018/12/25 11:31
 */

//提供配置
@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("宝马720");
        car.setColor("红色");
        car.setMaxSpeed(100);
        return car;
    }



}
