package com.tima.ai.callCmc.call_CMC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication()

public class CallCmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallCmcApplication.class, args);
	}

}
