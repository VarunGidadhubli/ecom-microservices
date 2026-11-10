package com.ecom.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecom.order.config.InventoryFeignClientConfig;
import com.ecom.order.dto.Inventory;

@FeignClient(name="ecom-inventory-service", configuration = InventoryFeignClientConfig.class)
public interface InventoryClient {
	
	@GetMapping("/api/inventory/{productId}")
	Inventory getInventory(@PathVariable Long productId);
	
	@PutMapping("/api/inventory")
	String updateInventory(@RequestBody Inventory inventory);
}