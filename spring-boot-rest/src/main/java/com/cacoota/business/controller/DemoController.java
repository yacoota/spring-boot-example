package com.cacoota.business.controller;


import com.cacoota.business.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String index(@PathVariable String id) {
        return id;
    }


    @PostMapping("/demos")
    @ResponseStatus(HttpStatus.CREATED)
    public Object insert(@RequestBody Demo demo) {
        return null;
    }

    @PatchMapping("/demos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object update(@PathVariable("id") String id, @RequestBody Demo demo) {
        return null;
    }

    @PutMapping("/demos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object modify(@PathVariable("id") String id, @RequestBody Demo demo) {
        return null;
    }

    @DeleteMapping(value = "/demos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {

    }

}
