package com.demo.spring;

/**
 * @author Clay
 * @date 2019/7/5 17:55
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param resourceLoader 资源加载器
     */
    protected XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }
}
