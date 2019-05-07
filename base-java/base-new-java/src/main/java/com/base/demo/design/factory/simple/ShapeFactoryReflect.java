package com.base.demo.design.factory.simple;

/**
 * @author tangwei
 * @date 2019/3/5 19:15
 */
public class ShapeFactoryReflect {


    public static Object getShape(Class<? extends Shape> clazz) {
        Object object = null;
        try {
            object = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
