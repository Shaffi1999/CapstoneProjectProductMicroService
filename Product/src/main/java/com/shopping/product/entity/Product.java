package com.shopping.product.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private int id;
	@NotNull(message="Product Name Can Not Be Empty")
	private String productName;
	
	private long price;
	
	private int stockCount;



}
