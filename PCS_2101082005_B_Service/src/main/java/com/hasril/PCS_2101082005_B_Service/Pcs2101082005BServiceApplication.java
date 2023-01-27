package com.hasril.PCS_2101082005_B_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Pcs2101082005BServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pcs2101082005BServiceApplication.class, args);
	}
@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
