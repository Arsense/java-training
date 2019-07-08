package com.base.java.thread.tongbu.notify;

/**
 * @author Clay
 * @date 2018/12/12 21:06
 */
public class Task implements  Runnable {

    static Blocker blocker = new Blocker();
    @Override
    public void run() {
        blocker.waitCall();
    }
}
