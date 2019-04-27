package com.base.java.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tangwei
 * @date 2019/4/27 18:10
 */
public class ReadWriteLockDemo implements Runnable {
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    int value;
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();


    @Override
    public void run() {

    }
}
