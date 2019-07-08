package com.base.java.thread.tongbu.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Clay
 * @date 2018/12/13 14:47
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private Random rand = new Random(47);

    private int count = 0;

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MICROSECONDS.sleep(100 + rand.nextInt(500));
                //开始做Toast
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            } catch (InterruptedException e) {
                System.out.println("Butterer interrupt");
            }
        }
        System.out.println("Toaster off!");
    }
}
