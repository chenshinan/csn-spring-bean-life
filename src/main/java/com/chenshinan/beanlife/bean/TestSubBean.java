package com.chenshinan.beanlife.bean;

import org.springframework.stereotype.Component;

/**
 * @author shinan.chen
 * @date 2018/11/1
 */
@Component
public class TestSubBean {
    public TestSubBean() {
        System.out.println("【构造器】调用TestSubBean的构造器实例化");
    }
}
