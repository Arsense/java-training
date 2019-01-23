package com.base.java.jvm.classloader;

/**
 * @author tangwei
 * @date 2018/12/21 11:25
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader("E:");
        Class<?> c = loader.loadClass("com.thread1.test.example.classloader.HelloWorld");
        System.out.println(c.getClassLoader());
    }
}
