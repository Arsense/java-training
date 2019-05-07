package base.java.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author tangwei
 * @date 2018/12/25 14:22
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            BeanCar car = (BeanCar) bean;
            if(car.getColor() == null) {
                System.out.println("调用BeanPostProcessor BeforeInitialization color为空,设置成黑色");
            }
            car.setColor("黑色");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            BeanCar car = (BeanCar) bean;
            if(car.getMaxSpeed() >= 200) {
                System.out.println("调用BeanPostProcessor AfterInitializationcolor为空,将Speed设置为 200");
            }
            car.setMaxSpeed(200);
        }
        return bean;
    }
}
