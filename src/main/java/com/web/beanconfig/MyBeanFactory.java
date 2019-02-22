package com.web.beanconfig;

import org.springframework.beans.factory.FactoryBean;

public class MyBeanFactory implements FactoryBean<Car> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Car getObject() {
        return new Car(name,5000000);
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
