package com.demo.spring;

import java.util.HashMap;
import java.util.Map;

/**
 *  抽象的bean定义读取类
 * @author tangwei
 * @date 2019/7/5 17:46
 */
public abstract  class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 注册bean容器
     */
    private Map<String, BeanDefinition> beansRegistry;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;

    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param resourceLoader 资源加载器
     */
    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.beansRegistry = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

       /**
     * 获取容器
     */
    public Map<String, BeanDefinition> getRegistry() {
        return beansRegistry;
    }

    /**
     * 获取资源加载器
     */
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
