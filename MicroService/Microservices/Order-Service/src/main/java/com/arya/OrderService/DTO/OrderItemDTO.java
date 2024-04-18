package com.arya.OrderService.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
	private long id;
	private String skucode;
	private BigDecimal price;
	private Integer quantity; 
}
