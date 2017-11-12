package com.simple.crud.main;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "com.simple.crud.domain")
@EnableJpaRepositories(basePackages = "com.simple.crud.repository")
@ComponentScan(basePackages = { "com.simple.crud.controller", "com.simple.crud.service" })

public class SpringRestCRUDMain {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringRestCRUDMain.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
