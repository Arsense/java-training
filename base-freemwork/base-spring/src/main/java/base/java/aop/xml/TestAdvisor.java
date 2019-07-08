package base.java.aop.xml;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * @author tangwei
 * @date 2019/7/8 1:25
 */
public class TestAdvisor implements PointcutAdvisor {
    /**
     *  获取通知处理逻辑
     * @return
     */
    @Override
    public Pointcut getPointcut() {
        return new TestPointcut();
    }

    @Override
    public Advice getAdvice() {
        return  new TestAfterAdvice();

    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
