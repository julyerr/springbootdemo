package com.julyerr.springboot.quickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulApiDemo {
    @RequestMapping("/api")
    String home() {
        return "hello,api";
    }
}
