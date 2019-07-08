package com.base.demo.myspring.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * @author Clay
 * @date 2019/4/23 11:16
 *
 * @see <a href="http://thinkinjava.cn/2017/12/07/2017-12-07-%E6%B7%B1%E5%85%A5%E7%90%86%E8%A7%A3Spring-%E4%B9%8B-%E6%BA%90%E7%A0%81%E5%89%96%E6%9E%90AOP%EF%BC%88XML%E9%85%8D%E7%BD%AE%E6%96%B9%E5%BC%8F%EF%BC%89/">http://google.com</a>
 * <a></a>
 */
public class TestPointcut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> aClass) {
                if (method.getName().equals("test")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean isRuntime() {
                return true;
            }

            @Override
            public boolean matches(Method method, Class<?> aClass, Object... objects) {
                if (method.getName().equals("test")) {
                    return true;
                }
                return false;
            }
        };
    }
}
