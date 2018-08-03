package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/auth")
public class UserAuthController {
    @RequestMapping("/{page")
    public String List(@PathVariable String page){
        return  "sys/auth/" +page;
    }
}
