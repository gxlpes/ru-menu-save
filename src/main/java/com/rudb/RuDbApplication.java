package com.rudb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RuDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuDbApplication.class, args);
	}

}
