package br.com.phoebustecnologia.SaleMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SaleMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleMicroserviceApplication.class, args);
	}

}
