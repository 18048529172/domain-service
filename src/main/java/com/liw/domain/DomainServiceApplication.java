package com.liw.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomainServiceApplication.class, args);
	}
}
