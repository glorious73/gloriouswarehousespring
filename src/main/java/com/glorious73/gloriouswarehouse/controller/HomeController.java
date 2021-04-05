package com.glorious73.gloriouswarehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Main() {
        return "Hello world from Spring Boot!";
    }
}
