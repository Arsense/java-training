package com.base.java.rpc.dubbo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Clay
 * @date 2019/2/12 15:01
 */
public class ProxyHandler implements InvocationHandler {
    private Class interfaceClass;
    public ProxyHandler(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }
    //返回代码对象
    public <T> T getProxyObject(){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{interfaceClass},this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        System.out.println("进行编码");
        System.out.println("发送网络请求");
        System.out.println("将网络请求结果进行解码并返回");
        return null;
    }


    public static void main(String[] args) {
        ProxyHandler proxyHandler  = new ProxyHandler(MenuService.class);
        MenuService menuService = proxyHandler.getProxyObject();
        menuService.sayHello();
    }
}
