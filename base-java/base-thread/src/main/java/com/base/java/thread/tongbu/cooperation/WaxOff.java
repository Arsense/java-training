package com.base.java.thread.tongbu.cooperation;

import java.util.concurrent.TimeUnit;

/**
 * @author Clay
 * @date 2018/12/12 17:11
 */
public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                car.waitForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MICROSECONDS.sleep(200);
                car.buffed();
            } catch (InterruptedException e) {
                System.out.println("WaxOff interrupted");

            }

        }
        System.out.println("ending Wax Off task! ");
    }
}
