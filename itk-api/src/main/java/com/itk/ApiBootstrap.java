package com.itk;

import com.itk.config.ItkProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:applicationContext-dubbo.xml"})
@EnableConfigurationProperties(ItkProperties.class)
public class ApiBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(ApiBootstrap.class, args);
	}

}
