package com.coderahul.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodCatalogueMicroservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogueMicroservice1Application.class, args);
	}

    //As Spring will given Restaurant bean which not so busy
    @Bean
    @LoadBalanced
    public  RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}

}
