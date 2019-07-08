package com.base.java.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Clay
 * @date 2019/4/26 17:46
 */
public class Demo2 implements Runnable {
    /**
     * Re - entrant - Lock
     * 重入锁，表示在单个线程内，这个锁可以反复进入，也就是说，一个线程可以连续两次获得同一把锁。
     * 如果你不允许重入，将导致死锁。注意，lock 和 unlock 次数一定要相同，如果不同，就会导致死锁和监视器异常。
     *
     * synchronized 只有2种情况：1继续执行，2保持等待。
     */
    static Lock lock = new ReentrantLock();
    static int i;

    public static void main(String[] args) throws InterruptedException {
        Demo2 demo2 = new Demo2();
        Thread t1 = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                // 因为lock 如果发生了异常，是不会释放锁的，所以必须在 finally 块中释放锁
                // synchronized 发生异常会主动释放锁
                lock.unlock();
            }
        }
    }

}
