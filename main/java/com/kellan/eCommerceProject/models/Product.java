package com.kellan.eCommerceProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	// id that auto increments
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private String id;
	// int quantity
	private int quantity;
	// int (double?) price
	private double price;	
	// String description
	private String description;
	// String name
	private String name;
	// String brand (quote?)
	private String quote;
	// String category
	private String category;
	// image url (how?)	
	

}
