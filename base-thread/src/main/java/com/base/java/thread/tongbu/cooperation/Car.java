package com.base.java.thread.tongbu.cooperation;

/**
 * @author tangwei
 * @date 2018/12/12 17:11
 */
public class Car {

    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing()
    throws InterruptedException{
        while (!waxOn)
            wait();
    }

    public synchronized void waitForBuffing()
            throws InterruptedException{
        while (waxOn)
            wait();
    }


}
