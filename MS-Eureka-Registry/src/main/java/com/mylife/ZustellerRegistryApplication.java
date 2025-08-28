package com.mylife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZustellerRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZustellerRegistryApplication.class, args);
	}
}
