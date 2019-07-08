package com.base.java.thread.tongbu.notify;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * notifyAll 只会换起相同类下所有等待的线程
 *
 * @author Clay
 * @date 2018/12/12 21:08
 */
public class NotifyMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0;i < 5;i++) {
            executor.execute(new Task());
        }
        executor.execute(new Task1());
        //时间函数
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean notify = true;
            @Override
            public void run() {
                if (notify) {
                    System.out.println("\n notify()");
                    Task.blocker.wackUp();
                    notify = false;
                } else {
                    System.out.println("\n notifyAll()");
                    Task.blocker.wackUpAll();
                    notify = true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("timer canceled");
        TimeUnit.MICROSECONDS.sleep(500);
        System.out.println("Task2 notifyAll()");
        Task1.blocker.wackUpAll();
        TimeUnit.MICROSECONDS.sleep(500);
        System.out.println("Shutting down");

        executor.shutdownNow();


    }
}
