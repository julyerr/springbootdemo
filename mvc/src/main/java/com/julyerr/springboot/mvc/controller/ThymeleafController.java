package com.julyerr.springboot.mvc.controller;

import com.julyerr.springboot.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("title", "学生列表");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(123, "zhangsan"));
        studentList.add(new Student(124, "lisi"));
        model.addAttribute("studentList", studentList);
        return "student/list";
    }

    @RequestMapping("/studentsView")
    public ModelAndView getStudents(ModelAndView modelAndView) {
        modelAndView.setViewName("student/list");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(123, "zhangsan"));
        studentList.add(new Student(124, "lisi"));
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }
}
