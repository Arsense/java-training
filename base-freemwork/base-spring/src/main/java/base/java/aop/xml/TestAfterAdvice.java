package base.java.aop.xml;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2019/7/8 1:23
 */
public class TestAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterReturning==== " + method.getName());
    }
}
