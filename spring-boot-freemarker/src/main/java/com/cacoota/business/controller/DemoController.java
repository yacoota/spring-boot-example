package com.cacoota.business.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping(value = {"", "/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("chat/index");
    }

}
