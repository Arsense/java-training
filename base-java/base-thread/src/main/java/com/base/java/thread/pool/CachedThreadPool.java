package com.base.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Clay
 * @date 2018/12/12 10:03
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0;i < 5;i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

}
