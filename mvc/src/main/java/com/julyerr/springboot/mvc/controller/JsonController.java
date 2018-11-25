package com.julyerr.springboot.mvc.controller;

import com.julyerr.springboot.mvc.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonController {

    @RequestMapping("/student")
    public Student getStudent() {
        Student student = new Student();
        student.setId(123);
        student.setName("julyerr");
        student.setDate(new Date());
        return student;
    }
}
