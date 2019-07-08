package base.java.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Clay
 * @date 2019/7/8 16:41
 */
@Aspect
@Component
public class Aop {
    @Around("execution(* base.java.springboot.*Controller.test*(..))")
    public Object test(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("this is hello before");
        Object object = joinPoint.proceed();
        System.out.println("hello after");
        return object;
    }

    @Around("execution(* base.java.springboot.*Controller.test*(..))")
    public void test2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("this is hello22 before");
        joinPoint.proceed();
        System.out.println("hello22 after");
    }
}
