package com.base.java.spring.ioc.beanlife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author tangwei
 * @date 2018/12/25 14:34
 */
public class BeanLifeTest {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("spring-bean.xml");

        BeanFactory beanFactory = new XmlBeanFactory(resource);

        //向容器中注册处理器
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory)beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //第一次从容器中获取Car
        BeanCar car1 = (BeanCar) beanFactory.getBean("car");
        car1.toString();
        car1.setColor("红色");


        //第二次获取
        BeanCar car2 = (BeanCar) beanFactory.getBean("car");

//        查看是否指向同意引用
        System.out.println("car1 == car2结果为"+ (car1==car2));
        ((XmlBeanFactory)beanFactory).destroySingletons();

    }
}
