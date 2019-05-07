package com.base.demo.design.proxy.dynamic.jdkproxy;

import com.base.demo.design.proxy.UserDao;
import com.base.demo.design.proxy.UserDaoImpl;

/**
 * @author tangwei
 * @date 2019/3/5 17:58
 */
public class App1 {
    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDaoImpl();
        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        // 给目标对象，创建代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}
