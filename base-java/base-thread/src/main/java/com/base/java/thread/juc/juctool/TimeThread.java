package com.base.java.thread.juc.juctool;

/**
 * @author tangwei
 * @date 2019/5/23 10:37
 */
public class TimeThread implements Runnable{
    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }
}
