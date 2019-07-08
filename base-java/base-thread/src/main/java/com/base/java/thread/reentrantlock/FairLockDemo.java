package com.base.java.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Clay
 * @date 2019/4/26 18:13
 */
public class FairLockDemo implements Runnable {

    private Lock unfairLock = new ReentrantLock(false);
    private Lock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                unfairLock.lock();
                System.out.println(Thread.currentThread().getName() +  "获得锁");
            } finally {
                unfairLock.unlock();
            }
        }
    }


    /**
     * 默认是不公平的锁，设置为 true 为公平锁
     *
     * 公平：在多个线程的争用下，这些锁倾向于将访问权授予等待时间最长的线程；
     * 使用公平锁的程序在许多线程访问时表现为很低的总体吞吐量（即速度很慢，常常极其慢）
     * 还要注意的是，未定时的 tryLock 方法并没有使用公平设置
     *
     * 不公平：此锁将无法保证任何特定访问顺序，但是效率很高
     *
     */
    public static void main(String[] args) {
        FairLockDemo fairLockDemo = new FairLockDemo();
        Thread thread1 = new Thread(fairLockDemo,"cxs-t1");
        Thread thread2 = new Thread(fairLockDemo,"cxs-t2");
        thread1.start();
        thread2.start();
    }
}
