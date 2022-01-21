package com.example.templatemicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class myController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String doGet(@RequestParam(value = "name", defaultValue = "World") String name){

        List<String> service = discoveryClient.getServices();
        return ("Hello Services List: "+ service);
    }

}
