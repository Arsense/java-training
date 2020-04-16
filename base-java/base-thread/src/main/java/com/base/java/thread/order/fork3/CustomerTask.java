package com.base.java.thread.order.fork3;

import com.base.java.thread.order.domain.CustomerInfo;


import java.util.concurrent.RecursiveTask;

/**
 * @author tangwei
 * @date 2020/4/16 18:22
 */
public class CustomerTask extends RecursiveTask<CustomerInfo> {
    @Override
    protected CustomerInfo compute() {
        System.out.println("执行"+ this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new CustomerInfo();
    }
}
