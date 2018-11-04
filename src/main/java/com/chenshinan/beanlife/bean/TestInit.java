package com.chenshinan.beanlife.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author shinan.chen
 * @date 2018/11/4
 */
public class TestInit implements InitializingBean, DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean的destroy方法：testInit");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的afterPropertiesSet方法：testInit");
    }
    /**
     * 通过<bean>的init-method属性指定的初始化方法
     */
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    /**
     * 通过<bean>的destroy-method属性指定的初始化方法
     */
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("执行【postConstruct】的初始化方法");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("执行【preDestroy】的销毁方法");
    }
}
