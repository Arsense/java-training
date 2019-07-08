package base.java.ioc;

import base.java.ioc.beanno.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2018/12/25 10:39
 */
public class ReflectTest {


    public static Car initCarByReflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
         //初始化类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.spring.demo.Car");

        //获取类构造器
        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car) constructor.newInstance();

        //反射放设置属性

        Method setBrand = clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car, "宝马车");

        Method setColor = clazz.getMethod("setColor",String.class);
        setColor.invoke(car, "颜色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed",Integer.class);
        setMaxSpeed.invoke(car, 12);

        return car;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Car car = initCarByReflect();
        System.out.println(car.toString());
    }

}
