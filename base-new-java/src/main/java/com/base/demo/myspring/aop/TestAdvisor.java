package com.base.demo.myspring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * @author tangwei
 * @date 2019/4/23 11:21
 */
public class TestAdvisor implements PointcutAdvisor {

    /**
     * 获取通知处理逻辑
     */
    @Override
    public Pointcut getPointcut() {
        return new TestPointcut();
    }
    /**
     * 获取切入点
     */
    @Override
    public Advice getAdvice() {
        return new TestAfterAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
