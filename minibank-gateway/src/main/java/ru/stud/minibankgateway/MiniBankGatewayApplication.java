package ru.stud.minibankgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class MiniBankGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBankGatewayApplication.class, args);
	}

}
