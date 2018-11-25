package com.julyerr.springboot.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class Factory implements FactoryBean<FacBean> {

    @Override
    public FacBean getObject() throws Exception {
        return new FacBean();
    }

    @Override
    public Class<?> getObjectType() {
        return FacBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
