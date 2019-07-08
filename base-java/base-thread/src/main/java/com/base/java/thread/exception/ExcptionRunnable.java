package com.base.java.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 线程异常
 *
 * @author Clay
 * @date 2018/12/12 16:16
 */
public class ExcptionRunnable {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executor.execute(new ExceptionThread2());
        executor.shutdown();
    }
}
