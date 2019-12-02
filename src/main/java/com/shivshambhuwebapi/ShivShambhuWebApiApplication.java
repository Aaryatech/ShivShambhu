package com.shivshambhuwebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShivShambhuWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShivShambhuWebApiApplication.class, args);
	}
}
