package com.base.java.thread.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 响应中断
 *
 * @author tangwei
 * @date 2019/4/26 17:59
 */
public class InterruptLockDemo implements Runnable {


    /**
     * 默认是不公平的锁，设置为 true 为公平锁
     *
     * 公平：在多个线程的争用下，这些锁倾向于将访问权授予等待时间最长的线程；
     * 使用公平锁的程序在许多线程访问时表现为很低的总体吞吐量（即速度很慢，常常极其慢）
     * 还要注意的是，未定时的 tryLock 方法并没有使用公平设置
     *
     * 不公平：此锁将无法保证任何特定访问顺序
     *
     * 拾遗：1 该类的序列化与内置锁的行为方式相同：一个反序列化的锁处于解除锁定状态，不管它被序列化时的状态是怎样的。
     *      2.此锁最多支持同一个线程发起的 2147483648 个递归锁。试图超过此限制会导致由锁方法抛出的 Error。
     */
    static ReentrantLock lock1 = new ReentrantLock(true);
    static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public InterruptLockDemo(int lock) {
        this.lock = lock;
    }

    public int getLock() {
        return lock;
    }

    @Override
    public void run() {
        try {
            if(lock == 1) {
                try {
                    // 如果当前线程未被中断，则获取锁。
                    lock1.lockInterruptibly();// 即在等待锁的过程中，可以响应中断。
                    Thread.sleep(500);
                    // 试图获取 lock 2 的锁
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    lock2.lockInterruptibly();
                    Thread.sleep(500);
                    // 该线程在企图获取 lock1 的时候，会死锁，但被调用了 thread.interrupt 方法，导致中断。中断会放弃锁。
                    lock1.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        } finally {
            if(lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }

            if(lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }

            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }


    }


    public static void main(String[] args) throws InterruptedException {

        /**
         * 这部分代码主要是针对 lockInterruptibly 方法，该方法在线程发生死锁的时候可以中断线程。让线程放弃锁。
         * 而 synchronized 是没有这个功能的， 他要么获得锁继续执行，要么继续等待锁。
         */

        InterruptLockDemo r1 = new InterruptLockDemo(1);
        InterruptLockDemo r2 = new InterruptLockDemo(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 中断其中一个线程（只有线程在等待锁的过程中才有效）
        // 如果线程已经拿到了锁，中断是不起任何作用的。
        // 注意：这点 synchronized 是不能实现此功能的，synchronized 在等待过程中无法中断
        t2.interrupt();
        // t2 线程中断，抛出异常，并放开锁。没有完成任务
        // t1 顺利完成任务。
    }
}
