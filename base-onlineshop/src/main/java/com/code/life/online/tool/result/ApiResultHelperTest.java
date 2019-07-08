package com.code.life.online.tool.result;


/**
 * @author Clay
 * @date 2019/5/22 14:14
 */
public class ApiResultHelperTest {


    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Protocol protocol = new Protocol();
        ApiResultHelper apiResultHelper = new ApiResultHelper();

        //使用这种方法要统一接口规范 都是两参的入参才可以
        String result = apiResultHelper.doExcute(1234L, protocol, orderService::createOrder);
        System.out.println("orderService::createOrder 结果是" + result);
        String logPath = "sdsdasd";

        boolean result1 = apiResultHelper.doExcute(logPath, protocol, orderService::deleteLog);
        if (result1) {
            System.out.println("orderService::deleteLog执行成功");
        }

    }
}
