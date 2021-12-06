package com.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProductsInCart implements Serializable {

	
	private static final long serialVersionUID = 1726984765703163766L;
	private int itemId;
	private int quantity;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductsInCart [itemId=" + itemId + ", quantity=" + quantity + "]";
	}
	
	
}
