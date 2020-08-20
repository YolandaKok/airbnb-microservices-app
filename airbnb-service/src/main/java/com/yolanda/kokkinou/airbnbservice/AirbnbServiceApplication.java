package com.yolanda.kokkinou.airbnbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AirbnbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirbnbServiceApplication.class, args);
	}

}
