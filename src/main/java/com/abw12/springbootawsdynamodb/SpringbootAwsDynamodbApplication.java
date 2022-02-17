package com.abw12.springbootawsdynamodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.abw12.springbootawsdynamodb.*")
public class SpringbootAwsDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsDynamodbApplication.class, args);
	}

}
