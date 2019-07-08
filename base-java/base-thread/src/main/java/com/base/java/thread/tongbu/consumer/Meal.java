package com.base.java.thread.tongbu.consumer;

/**
 * @author Clay
 * @date 2018/12/12 21:37
 */
public class Meal {
    private final int orderNumber;

    public Meal(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String toString(){
        return "Meal " + orderNumber;
    }


}
