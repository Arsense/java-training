package com.base.java.thread.tool;

import java.util.concurrent.locks.LockSupport;

/**
 * @author tangwei
 * @date 2019/4/28 20:03
 */
public class LockSupportDemo {

    static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");
    static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                // wait
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.err.println(getName() + "被中断了");
                }
            }
            System.out.println(getName() + "执行结束了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(3000);
        //中断
        t1.interrupt();
        // notify
        LockSupport.unpark(t2);
    }
}


