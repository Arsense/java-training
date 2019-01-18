package com.base.java.thread.tongbu.toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author tangwei
 * @date 2018/12/13 14:51
 */
public class ToastMain {


    public static void main(String[] args) {

        ToastQueue toastQueue = new ToastQueue(),
                   bufferedQueue = new ToastQueue(),
                   finishedQueue = new ToastQueue();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Toaster(toastQueue));
        executor.execute(new Butterer(toastQueue, bufferedQueue));
        executor.execute(new Jammer(bufferedQueue, finishedQueue));
        executor.execute(new Eater(finishedQueue));
        try {
            TimeUnit.SECONDS.sleep(5);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
