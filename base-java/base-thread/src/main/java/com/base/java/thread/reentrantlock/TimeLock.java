package com.base.java.thread.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangwei
 * @date 2019/4/26 18:12
 */
public class TimeLock implements Runnable {

    static ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        try {
            // 最多等待5秒，超过5秒返回false，若获得锁，则返回true
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                // 锁住 6 秒，让下一个线程无法获取锁
                System.out.println("锁住 6 秒，让下一个线程无法获取锁");
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);

        t1.start();
        t2.start();


    }
}