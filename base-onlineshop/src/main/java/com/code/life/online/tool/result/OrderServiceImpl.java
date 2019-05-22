package com.code.life.online.tool.result;

/**
 * @author tangwei
 * @date 2019/5/22 14:11
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public String createOrder(Protocol protocol, Long orderId) {
        System.out.println("开始创建订单, orderId:" + orderId);
        return "订单创建成功";
    }

    @Override
    public boolean deleteLog(Protocol protocol, String logPath) {
        System.out.println("删除日志:" + logPath);
        return true;
    }

}
