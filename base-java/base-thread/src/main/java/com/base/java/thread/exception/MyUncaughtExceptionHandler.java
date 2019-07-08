package com.base.java.thread.exception;

/**
 * @author Clay
 * @date 2018/12/12 16:13
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught" + e);
    }
}
