package com.ecom.order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.ecom.order.client.InventoryClient;
import com.ecom.order.dto.Inventory;

@Service
public class OrderService {

	private final RestClient restClient;
	private final InventoryClient inventoryClient;

	public OrderService(RestClient restClient, InventoryClient inventoryClient) {
		this.restClient = restClient;
		this.inventoryClient = inventoryClient;
	}

	public String placeOrder(Long productId) {

		Inventory inventory = inventoryClient.getInventory(productId);
		updateInventory(inventory);
		return inventory.getQuantity() > 0 ? "Order Placed Successfully" : "Product Out Of Stock";
	}

	private void updateInventory(Inventory inventory) {
		inventory.setQuantity(inventory.getQuantity() - 1);
		inventoryClient.updateInventory(inventory);
	}
}