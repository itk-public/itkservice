package com.itk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:applicationContext-dubbo.xml"})
public class ApiBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(ApiBootstrap.class, args);
	}

}
