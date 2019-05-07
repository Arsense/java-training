package com.base.java.freemwork.singleton;

/** 懒汉 线程不安全
 * @author tangwei
 * @date 2019/3/5 19:56
 */
public class Singleton1 {

    private static  Singleton1 singleton1 = null;
    private Singleton1(){
        System.out.println("初始化完成");
    }
    public static Singleton1 getSingleton1() {
        if(singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

}
