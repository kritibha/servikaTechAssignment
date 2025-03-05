package com.sarvikatech.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvikatech.order_service.dto.OrderDto;
import com.sarvikatech.order_service.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order Service Management", description = "Operations related to orders.")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/{userId}")
	@Operation(summary = "Create a new order", description = "Placing a new order after Authorizing the userId exist in the h2 database USERS table calling userService microservice here, if userId exists then placing the order else giving resutl 'User not found' in result.")
	public String placeOrder(@PathVariable("userId") Long userId, @RequestBody OrderDto orderDto) {
		String msg = orderService.placeOrder(userId, orderDto);
		return msg;
	}

}
