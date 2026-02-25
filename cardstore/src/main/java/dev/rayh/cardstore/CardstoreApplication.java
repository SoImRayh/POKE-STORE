package dev.rayh.cardstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CardstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardstoreApplication.class, args);
	}

}