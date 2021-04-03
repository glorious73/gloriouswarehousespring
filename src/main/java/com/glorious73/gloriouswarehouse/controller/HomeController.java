package com.glorious73.gloriouswarehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String Main() {
        return "Hello world from Spring Boot!";
    }
}
