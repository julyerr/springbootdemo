package com.julyerr.springboot.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
@SessionAttributes({"modelId", "sessionId"})
public class SessionModelAttrSetController {
    @RequestMapping("/setAttr")
    public String setAttr(Model model, HttpSession session) {
        model.addAttribute("modelId", "model");
        session.setAttribute("sessionId", "session");
        return "setAttr";
    }
}
