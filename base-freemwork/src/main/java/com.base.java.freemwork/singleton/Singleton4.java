package com.base.java.freemwork.singleton;

/** 尔汗
 * @author tangwei
 * @date 2019/3/5 19:57
 */
public class Singleton4 {

    private static  Singleton4 singleton4 = null;
    static {
        singleton4 = new Singleton4();
    }

    private Singleton4(){}
    public static Singleton4 getSingleton() {
        return singleton4;
    }
}
