package com.base.java.freemwork.singleton;

/**
 * @author tangwei
 * @date 2019/3/5 19:56
 */
public class Singleton3 {

    private static  Singleton3 singleton3 = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getSingleton() {
        return singleton3;
    }
}
