package com.ecom.order.service;

//import org.springframework.retry.annotation.Backoff;
//import org.springframework.retry.annotation.Retryable;

import com.ecom.order.client.InventoryClient;
import com.ecom.order.dto.Inventory;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

public class InventoryService {

	private final InventoryClient inventoryClient;

	public InventoryService(InventoryClient inventoryClient) {
		this.inventoryClient = inventoryClient;
	}

	//@Retryable(retryFor = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000))
	//@RateLimiter(name="inventoryService", fallbackMethod = "fallbackMethod")
	@CircuitBreaker(name="inventoryCircuitBreaker", fallbackMethod = "fallbackMethod")
	public Inventory getInventory(Long productId) {
		return inventoryClient.getInventory(productId);
	}
	
	public Inventory fallbackMethod(Long productId, Throwable throwable) {
		return new Inventory(productId.toString(),0);
	}
}