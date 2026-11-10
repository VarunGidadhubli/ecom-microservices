package com.ecom.order.config;

import java.time.Duration;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;

@Configuration
public class InventoryFeignClientConfig {

    private final RestTemplate restTemplate;

    InventoryFeignClientConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	@Bean
	Logger.Level feignInventoryLoggerLevel() {
		return Logger.Level.BASIC;
	}

	@Bean
	Request.Options options() {
		return new Request.Options(Duration.ofMillis(3000),Duration.ofMillis(5000),true);
	}
	
	@Bean
	Retryer retryer() {
		return new Retryer.Default(1L, 2L, 3);
	}
	
	@Bean
	RequestInterceptor requestInterceptor() {
		return requestTemplate -> { requestTemplate.header("x-Correlation-Id", UUID.randomUUID().toString());
		};
	}
}
