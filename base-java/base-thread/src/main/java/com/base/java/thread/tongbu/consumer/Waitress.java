package com.base.java.thread.tongbu.consumer;


/**
 * @author tangwei
 * @date 2018/12/13 11:02
 */
public class Waitress implements Runnable {
    //其实相当于这样是单例的 大家公用一个restaurant
    private Restaurant restaurant;

    Waitress(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                //等待食物吃完
                while (restaurant.meal == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Waitperson got " + restaurant.meal);
            synchronized (restaurant.chef) {
                restaurant.meal = null;
                restaurant.chef.notifyAll();
            }
        }
    }

}
