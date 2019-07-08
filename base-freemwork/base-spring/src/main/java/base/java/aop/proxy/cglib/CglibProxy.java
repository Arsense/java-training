package base.java.aop.proxy.cglib;

import base.java.aop.base.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2018/12/26 10:59
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setCallback(this);
        enhancer.setSuperclass(clazz);
        //通过字节码创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(object.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(object,objects);
        PerformanceMonitor.end();
        return result;
    }
}
