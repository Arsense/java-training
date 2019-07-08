package com.base.java.thread.exception;

import java.util.concurrent.ThreadFactory;

/**
 * @author Clay
 * @date 2018/12/12 16:14
 */
public class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "creating new Thread");
        Thread thread = new Thread();
        System.out.println("created" + thread);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        return thread;
    }



}
