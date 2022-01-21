package com.example.templatemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TemplateMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateMicroserviceApplication.class, args);
	}

}
