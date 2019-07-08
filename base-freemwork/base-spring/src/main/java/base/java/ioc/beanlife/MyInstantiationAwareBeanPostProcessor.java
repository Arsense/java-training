package base.java.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author Clay
 * @date 2018/12/25 14:17
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    //实例化Bean前进行调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("BeanPostProcessor.BeforeInstantiation调用");
        }
        return null;
    }

    //实例化bean后进行调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("BeanPostProcessor.AfterInstantiation调用");
        }
        return true;
    }

    //设置属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("BeanPostProcessor.PropertyValues调用");
        }
        return  pvs;
    }
}
