package com.julyerr.springboot.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionModelAttrGetController {
    @RequestMapping("/getAttr")
    public Map getAttr(@SessionAttribute("sessionId") String sessionId,
                       @ModelAttribute("modelId") String modelId) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("modelId", modelId);
        return map;
    }
}
