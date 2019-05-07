package com.base.java.thread.tongbu.cooperation;

import java.util.concurrent.TimeUnit;

/**
 * @author tangwei
 * @date 2018/12/12 17:11
 */
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                car.waitForBuffing();
                System.out.println("wax on! ");
                TimeUnit.MICROSECONDS.sleep(200);
                car.waxed();
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
        }
        System.out.println("Ending Wax On task!");


    }
}
