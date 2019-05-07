package com.base.demo.design.proxy.dynamic.cglib;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 * @author tangwei
 * @date 2019/3/5 18:06
 */
public class CglibProxyFactory implements MethodInterceptor {

    //维护目标对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }


    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务3...");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("提交事务3...");
        return returnValue;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback((Callback) this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }
}
