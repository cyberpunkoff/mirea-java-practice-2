package ru.mirea.edu.practice15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@EnableWebSecurity
public class Practice15Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice15Application.class, args);
	}

}
