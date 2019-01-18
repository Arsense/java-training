package com.base.java.spring.aop.jdkproxy;


import com.base.java.spring.aop.base.ForumService;
import com.base.java.spring.aop.base.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author tangwei
 * @date 2018/12/26 10:41
 */
public class JdkTestSerivce {

    public static void main(String[] args) {
        //创建代理关系
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);

        //创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                        target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        handler);
        proxy.removeForum(200);
        proxy.removeTopic(1121);
    }
}
