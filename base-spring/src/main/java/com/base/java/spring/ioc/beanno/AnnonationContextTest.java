package com.base.java.spring.ioc.beanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.Beans;

/**
 * @author tangwei
 * @date 2018/12/25 11:34
 */
public class AnnonationContextTest {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
         Car car = context.getBean("car", Car.class);
         int a = 1;
    }
}
