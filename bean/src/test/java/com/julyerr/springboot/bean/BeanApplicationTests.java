package com.julyerr.springboot.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void beanLoadTest(){
        System.out.println(SpringUtils.getBean("BeanDemo"));
        System.out.println(SpringUtils.getBean("facBeanDemo"));
    }
}
