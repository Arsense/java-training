package com.base.java.thread.pool;

import java.util.concurrent.*;

/**
 *
 *  线程池源码探究的测试用例
 *
 *
 * @author Clay
 * @date 2019/5/1 17:08
 */
public class ThreadPoolCodeDemo implements Runnable {


    public static void main(String[] args) {
        ThreadPoolCodeDemo demo = new ThreadPoolCodeDemo();
        ExecutorService service = new ThreadPoolExecutor(5,20,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 30; i++) {
            service.execute(demo);
        }

        service.shutdown();

    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + ": thread ID:" + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

