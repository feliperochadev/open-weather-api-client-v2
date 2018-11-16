package com.finleap.casestudy.feliperocha.openweatherapiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class OpenweatherapiclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenweatherapiclientApplication.class, args);
	}
}
