package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceReqProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceReqProjectApplication.class, args);
	}

}
