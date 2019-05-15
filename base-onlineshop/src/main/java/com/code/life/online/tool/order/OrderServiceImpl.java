package com.code.life.online.tool.order;

/**
 * @author tangwei
 * @date 2019/5/15 1:15
 */
public class OrderServiceImpl implements OrderService {


    private OrderCodeGenerator orderCodeGenerator = new OrderCodeGenerator();

    @Override
    public void createOrder() {
        //获取订单号
        String orderCode = orderCodeGenerator.getOrderCode();
        System.out.println(Thread.currentThread().getName() + "==============>订单号为:"
            + orderCode);
    }
}
