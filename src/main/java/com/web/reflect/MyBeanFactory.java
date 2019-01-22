package com.web.reflect;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyBeanFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public Object getBeanByName(String beanName){
        return applicationContext.getBean(beanName);
    }
    public Object getBeanByClass(Class<?> clazz){
        return applicationContext.getBean(clazz);
    }
}
