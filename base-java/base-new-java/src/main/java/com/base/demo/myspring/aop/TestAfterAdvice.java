package com.base.demo.myspring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2019/4/23 11:19
 */
public class TestAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("after "+ target.getClass().getName() + "." + method.getName());
    }
}
