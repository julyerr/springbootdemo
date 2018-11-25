package com.julyerr.springboot.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @Action("time statics")
    public String hello(String name) {
        return "hello" + name;
    }
}
