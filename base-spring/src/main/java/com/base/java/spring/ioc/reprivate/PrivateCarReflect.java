package com.base.java.spring.ioc.reprivate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <pre>
 *     测试反射获取私有对象
 *
 * </pre>
 *
 * @author tangwei
 * @date 2018/12/25 11:08
 */
public class PrivateCarReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.spring.demo.ioc.reprivate.PrivateCar");
        PrivateCar car = (PrivateCar) clazz.newInstance();

        //取消其私有属性
        Field field = clazz.getDeclaredField("color");
        field.setAccessible(true);
        field.set(car,"白色");

        Method drive = clazz.getDeclaredMethod("drive",null);
        //取消protected属性
        drive.setAccessible(true);
        drive.invoke(car, null);
    }

}
