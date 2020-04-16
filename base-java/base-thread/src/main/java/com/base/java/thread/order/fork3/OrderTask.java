package com.base.java.thread.order.fork3;

import com.base.java.thread.order.domain.OrderInfo;

import java.util.concurrent.RecursiveTask;

/**
 * @author tangwei
 * @date 2020/4/16 18:19
 */
public class OrderTask extends RecursiveTask<OrderInfo> {
    @Override
    protected OrderInfo compute() {

        OrderInfo orderInfo = new OrderInfo();
        System.out.println("OrderInfo,线程名字为:" + Thread.currentThread().getName());

        CustomerTask customerTask = new CustomerTask();
        OtherTask otherTask = new OtherTask();
        TenantTask tenantTask = new TenantTask();
        DiscountTask discountTask = new DiscountTask();
        FoodTask foodTask = new FoodTask();

        invokeAll(customerTask, otherTask, tenantTask, discountTask, foodTask);

        orderInfo.setCustomerInfo(customerTask.join());
        orderInfo.setTenant(tenantTask.join());
        orderInfo.setDiscount(discountTask.join());
        orderInfo.setFood(foodTask.join());
        orderInfo.setOtherInfo(otherTask.join());

        return orderInfo;
    }
}
