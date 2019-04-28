package com.base.java.thread.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tangwei
 * @date 2019/4/27 18:10
 */
public class ReadWriteLockDemo  {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock lock = new ReentrantLock();
    int value;
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();


    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            // 模拟读操作，读操作的耗时越多，读写锁的优势就越明显
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "读取到值" + value);
            return value;
        }  finally {
            lock.unlock();
        }
    }



    public void handleWrite(Lock lock, int newValue) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = newValue;
            System.out.println(Thread.currentThread().getName() + "写入值" + value);
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunable = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleRead(lock);
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable writeRunable = new Runnable() {
            @Override
            public void run() {
                try {
//                    demo.handleWrite(lock, new Random().nextInt());
                    demo.handleWrite(writeLock, new Random().nextInt());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        /**
         * 使用读写锁，这段程序只需要2秒左右
         * 使用普通的锁，这段程序需要20秒左右。
         */

        for (int i = 0; i < 18; i++) {
            new Thread(readRunable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunable).start();
        }



    }

}
