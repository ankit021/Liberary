package com.liberary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EntityScan(basePackages="com.liberary.Entity")@ComponentScan(basePackages="com.liberary")
public class LiberaryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiberaryManagementApplication.class, args);
	}

}
