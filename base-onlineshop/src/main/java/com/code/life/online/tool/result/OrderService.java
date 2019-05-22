package com.code.life.online.tool.result;

/** 模拟订单服务
 * @author tangwei
 * @date 2019/5/22 13:59
 */
public interface OrderService {

       String createOrder(Protocol protocol, Long orderId);

       boolean deleteLog(Protocol protocol, String logPath);

}
