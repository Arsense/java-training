package com.base.demo.design.proxy.dynamic.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Clay
 * @date 2019/3/5 17:54
 */
public class ProxyFactory {
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务2");
                //执行目标对象方法
                Object returnValue = method.invoke(target, args);
                System.out.println("提交事务2");
                return returnValue;
            }
        });
    }
}
