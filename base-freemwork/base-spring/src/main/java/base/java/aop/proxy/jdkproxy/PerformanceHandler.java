package base.java.aop.proxy.jdkproxy;

import base.java.aop.base.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2018/12/26 10:35
 */
public class PerformanceHandler implements InvocationHandler{
    private Object target;
    PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object object = method.invoke(target, args);
        PerformanceMonitor.end();
        return object;
    }
}
