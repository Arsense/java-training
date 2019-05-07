package com.base.demo.myspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author tangwei
 * @date 2019/4/23 11:36
 */
public class TestAop {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("/base-new-java/src/main/resources/spring-config.xml");
        TestTarget target = (TestTarget) applicationContext.getBean("testAOP");
        target.test();
        System.out.println("--------------------");
        target.test2();

    }
}
