package com.julyerr.springboot.mvc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
//针对context、servlet、session分别都有自己及其属性的listener
public class ListenerConfig implements ServletContextListener {
    final static Logger logger = LoggerFactory.getLogger(ListenerConfig.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("customer listener init");
    }
}
