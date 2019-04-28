package com.base.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwei
 * @date 2019/4/28 18:41
 */
public class ExtendThreadPoolDemo {



    private static class MyTask implements Runnable{

        String name;

        public MyTask(String name) {
            this.name = name;
        }


        @Override
        public void run() {
            System.out.println("正在执行：Thread ID:" + Thread.currentThread().getId() + ", Task Name = " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()){
            /**
             * 线程执行前
             * @param t
             * @param r
             */
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }

            /**
             * 线程执行中
             * @param r
             * @param t
             */
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成： " + ((MyTask) r).name);
            }

            /**
             * 所有线程执行完
             */
            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("task-game-" + i);
            executorService.execute(myTask);
            Thread.sleep(10);

        }

        //记得关闭线程池
        executorService.shutdown();

    }

}
