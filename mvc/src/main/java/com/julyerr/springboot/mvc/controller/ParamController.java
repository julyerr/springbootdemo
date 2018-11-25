package com.julyerr.springboot.mvc.controller;

import com.julyerr.springboot.mvc.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/{id}")
    public Map<String, Object> getId(@PathVariable Integer id,
                                     @RequestHeader("Accept-Encoding") String encodes) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("encodes", encodes);
        return map;
    }

    @RequestMapping(value = "/www-encoded", consumes = "application/x-www-form-urlencoded")
    public String getValue(@RequestParam("test") String test) {
        return test;
    }

    @RequestMapping(value = "/body-encoded", consumes = "application/json")
    public String getUser(@RequestBody Student student) {
        return student.toString();
    }
}
