package com.base.java.thread.tongbu.toast;


/**
 * @author tangwei
 * @date 2018/12/13 14:51
 */
public class Eater implements Runnable{

    private ToastQueue finishedQueue;
    int count = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                //开始做Toast
                Toast toast = finishedQueue.take();
                if(toast.getCount() != count++ || toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>Error toast" + toast);
                    System.exit(1);
                } else {
                    System.out.println("Chomp, nice toast!" + toast);
                }

            } catch (InterruptedException e) {
                System.out.println("Butterer interrupt");
            }
        }
        System.out.println("Eater off!");
    }
}
