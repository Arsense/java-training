package com.base.java.thread.tongbu.toast;

/**
 * @author tangwei
 * @date 2018/12/13 14:48
 */
public class Butterer implements Runnable{

    private ToastQueue toastQueue,bufferedQueue;

    public Butterer(ToastQueue toastQueue, ToastQueue bufferedQueue) {
        this.toastQueue = toastQueue;
        this.bufferedQueue = bufferedQueue;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toast toast = toastQueue.take();
                toast.buffer();
                System.out.println(toast);
                bufferedQueue.put(toast);
            } catch (InterruptedException e) {
                System.out.println("Butterer interrupt");

            }

        }

        System.out.println("Bufferer Off");

    }


}
