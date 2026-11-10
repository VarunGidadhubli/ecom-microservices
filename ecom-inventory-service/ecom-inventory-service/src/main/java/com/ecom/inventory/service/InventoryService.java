package com.ecom.inventory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecom.inventory.entity.Inventory;
import com.ecom.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public InventoryService(InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	public Inventory checkStock(Long productId) {
		Optional<Inventory> inventory = inventoryRepository.findById(productId);
		return inventory.get();
	}

	public String addProduct(Inventory inventory) {
		inventoryRepository.save(inventory);
		return "Product Added";
	}

	public String updateProduct(Inventory inventory) {

		inventoryRepository.save(inventory);
		return "Product updated";
	}

	public String deleteProduct(Long productId) {

		inventoryRepository.deleteById(productId);
		return "Product deleted";
	}
}