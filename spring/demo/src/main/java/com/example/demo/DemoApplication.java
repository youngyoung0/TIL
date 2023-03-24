package com.example.demo;

import com.example.demo.application.AsyncMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		AsyncMessageService asyncMessageService = new AsyncMessageService();
		for (int i = 0; i<100; i++){
			asyncMessageService.print(i + "");
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
