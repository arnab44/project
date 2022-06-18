package com.example.spring_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SpringDemo1Application {
    @Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return  new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDemo1Application.class, args);
	}

}
