package dev.rayh.cardstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableCaching
public class CardstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardstoreApplication.class, args);
	}

}