package com.julyerr.springboot.mvc.controller;

import com.julyerr.springboot.mvc.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerTest {
    @RequestMapping("/content")
    public String serviceController() {
        return "ok";
    }

    @RequestMapping("/stu")
    public Student student() {
        Student student = new Student();
        student.setId(123);
        student.setName("name");
        return student;
    }

    @PostMapping(value = "/stu", consumes = "application/json")
    public String saveStudent(@RequestBody Student student) {
        return "ok";
    }
}
