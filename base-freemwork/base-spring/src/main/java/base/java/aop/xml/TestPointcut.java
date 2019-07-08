package base.java.aop.xml;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * @author tangwei
 * @date 2019/7/8 1:19
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
            public boolean matches(Method method, Class<?> targetClass, Object[] args) {
                System.out.println(" in matches----------------");
                if (method.getName().equals("test")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                System.out.println(" in matches----------------");

                if (method.getName().equals("test")) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean isRuntime() {
                return true;
            }
        };
    }
}
