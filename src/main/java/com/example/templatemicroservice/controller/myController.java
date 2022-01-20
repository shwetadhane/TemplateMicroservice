package com.example.templatemicroservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @RequestMapping("/hello")
    public String doGet(@RequestParam(value = "name", defaultValue = "World") String name){

        return String.format("Hello %s!", name);
    }

}
