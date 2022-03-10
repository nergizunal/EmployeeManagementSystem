package com.self.EMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

}
