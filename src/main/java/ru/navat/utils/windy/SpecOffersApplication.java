package ru.navat.utils.windy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
//@EnableAutoConfiguration
@EnableCaching
@EnableAsync
public class SpecOffersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecOffersApplication.class, args);
	}

}
