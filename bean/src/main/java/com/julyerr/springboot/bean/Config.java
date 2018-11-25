package com.julyerr.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public BeanDemo BeanDemo(){
        return new BeanDemo();
    }

    @Bean
    public FacBean facBeanDemo(Factory factory) throws Exception {
        return factory.getObject();
    }
}
