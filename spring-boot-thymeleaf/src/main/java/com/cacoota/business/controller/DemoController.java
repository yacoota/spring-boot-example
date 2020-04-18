package com.cacoota.business.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = {"", "/", "/index"})
    public String index() {
        return "chat/index";
    }

}
