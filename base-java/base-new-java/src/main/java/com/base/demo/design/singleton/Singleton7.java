package com.base.demo.design.singleton;

/**
 * @author Clay
 * @date 2019/3/5 19:57
 */
public class Singleton7 {
    private volatile static Singleton7 singleton;
    private Singleton7 (){}
    public static Singleton7 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton7.class) {
                if (singleton == null) {
                    singleton = new Singleton7();
                }
            }
        }
        return singleton;
    }
}
