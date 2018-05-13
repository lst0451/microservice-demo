package com.lstmontreal.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name="MICROSERVICE-EMP")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
