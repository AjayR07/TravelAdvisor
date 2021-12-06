package com.models;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	private int userId;
	
	@Embedded
	private Set<ProductsInCart> products;
	
}
