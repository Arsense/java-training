package com.base.java.thread.tongbu.notify;


/**
 * notify对比
 *
 * @author tangwei
 * @date 2018/12/12 21:03
 */
public class Blocker {
    synchronized void waitCall(){
        while (!Thread.interrupted()) {
            try {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }catch (InterruptedException e) {
            }
        }
    }

    synchronized void wackUp() { notify();}
    synchronized void wackUpAll() { notifyAll();}

}
