package com.base.java.thread.exception;

/**
 * @author tangwei
 * @date 2018/12/12 16:11
 */
public class ExceptionThread2 implements Runnable {


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by" + thread);
        System.out.println("eh =" + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
