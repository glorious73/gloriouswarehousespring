package com.glorious73.gloriouswarehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String HelloWorld() {
        return "Hello world from Spring Boot!";
    }
}
