package com.base.java.thread.tongbu.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Clay
 * @date 2018/12/12 17:13
 */
public class CarWorker {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new WaxOff(car));
        executor.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        executor.shutdownNow();
    }

}
