package com.code.life.online.tool.order;

import java.util.concurrent.locks.Lock;

/**
 * @author Clay
 * @date 2019/5/19 16:05
 */
public class OrderServiceWithZkLock implements OrderService {

    //用Static修饰来获取用一个订单服务
    private static OrderCodeGenerator generator = new OrderCodeGenerator();

    //新订单创建
    @Override
    public void createOrder() {
        String orderCode = null;
        //分布式锁
        Lock lock = new ZKdistributeLock("/studyTest");
        try {
            lock.lock();
            orderCode = generator.getOrderCode();
        } catch (Exception e) {
            lock.unlock();
        }

        System.out.println(Thread.currentThread().getName() + "=============>" + orderCode);

        //业务代码 此处省略100行代码

    }
}
