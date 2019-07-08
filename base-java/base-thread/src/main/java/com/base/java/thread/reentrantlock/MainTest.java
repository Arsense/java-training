package com.base.java.thread.reentrantlock;

/**
 * @author Clay
 * @date 2018/12/28 10:54
 */
public class MainTest {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread a1 = new MyThread(service);
        MyThread a2= new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}
