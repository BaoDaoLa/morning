package com.otg.morning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MorningApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorningApplication.class, args);
	}
}