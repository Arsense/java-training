package com.base.java.freemwork.singleton;

/**懒汉 线程安全
 * @author tangwei
 * @date 2019/3/5 19:56
 */
public class Singleton2 {
    private static  Singleton2 singleton2 = null;
    private Singleton2(){
        System.out.println("初始化完成");
    }
    public static synchronized Singleton2 getSingleton() {
        if(singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
