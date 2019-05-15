package com.code.life.online.tool.order;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangwei
 * @date 2019/5/15 1:26
 */
public class OrderServiceWithLock implements OrderService {

    private Lock lock = new ReentrantLock();
    private OrderCodeGenerator orderCodeGenerator = new OrderCodeGenerator();

    @Override
    public void createOrder() {
        //获取订单号
        try {
            lock.lock();
            String orderCode = orderCodeGenerator.getOrderCode();
            System.out.println(Thread.currentThread().getName() + "==============>订单号为:"
                    + orderCode);
        }  finally {
            lock.unlock();

        }
    }
}
