package com.unizone.newsfeed_service;

import org.springframework.beans.factory.annotation.Value;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewsfeedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsfeedServiceApplication.class, args);
	}
}