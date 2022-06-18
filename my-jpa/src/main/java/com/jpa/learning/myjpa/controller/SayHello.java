package com.jpa.learning.myjpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
    @RequestMapping("/hi")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello "+ name;
    }
}
