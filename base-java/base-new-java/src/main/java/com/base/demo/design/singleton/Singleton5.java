package com.base.demo.design.singleton;

/**
 * @author tangwei
 * @date 2019/3/5 19:57
 */
public class Singleton5 {
    private static class ClassHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5(){}
    public static final Singleton5 getInstance() {
        return ClassHolder.INSTANCE;
    }

}
