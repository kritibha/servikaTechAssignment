package com.sarvikatech.order_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.sarvikatech.order_service.dto.OrderDto;
import com.sarvikatech.order_service.dto.OrderItemsDto;
import com.sarvikatech.order_service.entity.Order;
import com.sarvikatech.order_service.entity.OrderItems;
import com.sarvikatech.order_service.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
    private UserServiceClient userServiceClient;
	
	@Autowired
	OrderRepository orderRepo;
	
	public String placeOrder(Long userId, OrderDto orderDto) {
		User user = null;
		try {
			user = userServiceClient.getUserById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (user == null) {
//            throw new RuntimeException("User not found!");
        	return "User not found";
        }
        else {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderItems> orderItemsList = orderDto.getOrderItemsDtoList().stream()
		.map(items -> mapToDto(items)).toList();
		
		order.setOrderItemsList(orderItemsList);
		orderRepo.save(order);
		return "Order Placed Successfully.";
        }
	}

	private OrderItems mapToDto(OrderItemsDto orderItemsDto) {
		OrderItems orderItems = new OrderItems();
		orderItems.setPrice(orderItemsDto.getPrice());
		orderItems.setQuantity(orderItemsDto.getQuantity());
		orderItems.setProductCode(orderItemsDto.getProductCode());
		return orderItems;
	}

}
