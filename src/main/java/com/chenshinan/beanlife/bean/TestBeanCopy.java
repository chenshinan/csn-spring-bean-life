package com.chenshinan.beanlife.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author shinan.chen
 * @date 2018/11/1
 */
@Component
public class TestBeanCopy {
    private TestSubBeanCopy testSubBeanCopy;

    public TestBeanCopy(TestSubBeanCopy testSubBeanCopy) {
        this.testSubBeanCopy = testSubBeanCopy;
        System.out.println("【构造器】调用TestBeanCopy的构造器实例化");
    }
}
