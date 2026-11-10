package com.ecom.inventory.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.service.InventoryService;

@RequestMapping("/api/inventory")
@RestController
public class InventoryController {

	private final InventoryService inventoryService;

	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/{productId}")
	public String checkInventory(@PathVariable String productId) {

		return productId.equals("1") ? "In Stock" : "Out of Stock";
	}

	@PostMapping
	public String addProduct(@RequestBody Inventory inventory) {
		return inventoryService.addProduct(inventory);
	}

	@PutMapping()
	public String updateProduct(@RequestBody Inventory inventory) {
		return inventoryService.updateProduct(inventory);
	}

	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId) {
		return inventoryService.deleteProduct(productId);
	}
}