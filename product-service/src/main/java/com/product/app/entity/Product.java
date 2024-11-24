package com.product.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	private int id;
	private String productName;
	private double price;
	private String category;
}
