package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@RestController
public class DemoApplication {

	//Fetches secret value automatically for you, secret name : demosecreat
	//Assuming right keyvault configuration in place. refer application.properties file.
	@Value("${demosecret}")
	private String secretValue = "NONE";

	@RequestMapping("/")
	public String home() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	@RequestMapping("/secret")
	public String secret() {
		return secretValue;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
