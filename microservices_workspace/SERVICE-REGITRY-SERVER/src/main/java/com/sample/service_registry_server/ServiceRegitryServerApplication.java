package com.sample.service_registry_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegitryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegitryServerApplication.class, args);
	}

}
