package com.demo.spring;

import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;

/**
 * @author tangwei
 * @date 2019/7/5 17:36
 */
public class BeanDefinition {

    /**
     * bean
     */
    private Object bean;

    /**
     * bean 的 CLass 对象
     */
    private Class beanClass;

    /**
     * bean 的类全限定名称
     */
    private String ClassName;

    /**
     * 类的属性集合
     */
    private PropertyValues propertyValues = new PropertyValues() {
        @Override
        public PropertyValue[] getPropertyValues() {
            return new PropertyValue[0];
        }

        @Override
        public PropertyValue getPropertyValue(String s) {
            return null;
        }

        @Override
        public PropertyValues changesSince(PropertyValues propertyValues) {
            return null;
        }

        @Override
        public boolean contains(String s) {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    };


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getClassName() {

        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
        try {
            this.beanClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
