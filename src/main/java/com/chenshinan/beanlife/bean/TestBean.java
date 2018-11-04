package com.chenshinan.beanlife.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shinan.chen
 * @date 2018/11/1
 */
@Component
public class TestBean implements BeanFactoryAware, BeanNameAware{
    private String name;
    @Autowired
    private TestSubBean testSubBean;

    private BeanFactory beanFactory;
    private String beanName;

    public TestBean() {
        System.out.println("【构造器】调用TestBean的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("TestBean【注入属性】注入属性name："+name);
    }

    /**
     * 这是BeanFactoryAware接口方法
     *
     * @param arg0
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = arg0;
    }

    /**
     * 这是BeanNameAware接口方法
     *
     * @param arg0
     */
    @Override
    public void setBeanName(String arg0) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()："+arg0);
        this.beanName = arg0;
    }
}
