package com.base.java.thread.exercise.ch1;

/**
 * @author tangwei
 * @date 2020/4/8 23:56
 */

public class LockTest {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "已经获得a锁");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "睡眠5ms结束");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "已经获得b锁");
                }
            }
        }, "线程1").start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "已经获得b锁");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "睡眠5ms结束");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "已经获得a锁");
                }
            }
        }, "线程2").start();
    }
}
