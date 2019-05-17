package com.code.life.online.tool.order;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author tangwei
 * @date 2019/5/15 1:20
 */
public class OrderTestDemo {

    public static void main(String[] args) {
        //设置并发数
        int  currentThread = 30;
        System.out.println("用户下单开始============");
        //循环屏障
        CyclicBarrier cyclicBarrier = new CyclicBarrier(currentThread);

//        OrderService orderService = new OrderServiceImpl();

//        OrderService orderService = new OrderServiceWithLock();

        //多线程模拟并发
        for (int i = 0; i <= currentThread; i++) {
            new Thread( ()->{
                System.out.println(Thread.currentThread().getName() + "========》用户下单");
                //订单服务移进来 可以模拟多个TOMCAT
                OrderService orderService = new OrderServiceWithLock();

                try {
                    //等待一起执行
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                orderService.createOrder();
            }).start();
        }

    }

}
