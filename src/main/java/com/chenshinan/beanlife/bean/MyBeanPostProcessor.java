package com.chenshinan.beanlife.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author shinan.chen
 * @date 2018/10/31
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private TestBeanCopy testBeanCopy;
    
    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改："+beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改："+beanName);
        return bean;
    }
}
