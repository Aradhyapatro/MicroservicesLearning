package com.arya.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arya.OrderService.DTO.OrderRequestDTO;
import com.arya.OrderService.Service.orderService;

@RestController
@RequestMapping("/api/order")
public class orderControoler {
	@Autowired
	orderService service;

	@PostMapping(path="/")
	public String placeOrder(@RequestBody OrderRequestDTO orderRequest) throws Exception {
		service.placeOrder(orderRequest);
		return "Order Placed";
	}
}