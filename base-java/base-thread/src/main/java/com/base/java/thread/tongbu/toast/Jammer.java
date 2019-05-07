package com.base.java.thread.tongbu.toast;

/**
 * @author tangwei
 * @date 2018/12/13 14:48
 */
public class Jammer implements Runnable{

    private ToastQueue bufferedQueue,finishedQueue;

    public Jammer(ToastQueue bufferedQueue, ToastQueue finishedQueue) {
        this.bufferedQueue = bufferedQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toast toast = bufferedQueue.take();
                toast.jammed();
                System.out.println(toast);
                finishedQueue.put(toast);
            } catch (InterruptedException e) {
                System.out.println("Jammer interrupt");

            }

        }

        System.out.println("Jammer Off");
    }
}
