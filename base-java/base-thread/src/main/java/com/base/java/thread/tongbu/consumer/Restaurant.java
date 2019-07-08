package com.base.java.thread.tongbu.consumer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Clay
 * @date 2018/12/13 11:04
 */
public class Restaurant {
    Meal meal;
    ExecutorService  executor = Executors.newCachedThreadPool();
    Waitress waitress = new Waitress(this);
    Chef chef = new Chef(this);
    public Restaurant (){
        executor.execute(chef);
        executor.execute(waitress);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
