package com.ecom.order.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/{productId}")
	public String placeOrder(@PathVariable Long productId) {

		return orderService.placeOrder(productId);
	}
}