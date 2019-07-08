package com.base.java.thread.tongbu.notify;

/**
 * @author Clay
 * @date 2018/12/12 21:07
 */
public class Task1 implements Runnable{
    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitCall();
    }
}
