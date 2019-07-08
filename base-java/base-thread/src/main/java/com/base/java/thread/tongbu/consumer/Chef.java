package com.base.java.thread.tongbu.consumer;

import java.util.concurrent.TimeUnit;

/**
 * @author Clay
 * @date 2018/12/13 11:01
 */
public class Chef implements Runnable{

    private int count = 0;
    private Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                while (restaurant.meal != null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (++count == 10) {
                    System.out.print("食物已经足够了");
                    restaurant.executor.shutdownNow();
            }
            System.out.print("  Order UP");
            synchronized (restaurant.waitress) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitress.notifyAll();
            }
            try {
               TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    }
}
