package com.base.java.spring.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author tangwei
 * @date 2018/12/25 13:50
 */
public class BeanCar implements BeanFactoryAware, BeanNameAware,InitializingBean,
        DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public BeanCar() {
        System.out.println("调用Car()构造函数");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        System.out.println("调用setBrand()设置属性值");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "BeanCar{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    /**
     * BeanFactoryAware  接口
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory接口");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware 接口
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware setBeanName接口");
        this.beanName = s;
    }

    /**
     * DisposableBean接口
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean destroy接口");

    }

    /**
     * InitializingBean接口
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean  afterPropertiesSet接口");
    }

    public void myInit() {
        System.out.println("调用init-method所指定的myInit(), 将maxSpeed设为250");
        this.maxSpeed = 240;
    }

    public void myDestory() {
        System.out.println("调用init-destory所指定的myDestory()");

    }
}
