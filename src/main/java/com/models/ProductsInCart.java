package com.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProductsInCart implements Serializable {

	public ProductsInCart(int itemId, int quantity, float totalCost, CartDTO cart) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.cart = cart;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartProductId;
	
	private static final long serialVersionUID = 1726984765703163766L;
	private int itemId;
	@Transient
	private ItemDTO item;
	public ItemDTO getItem() {
		return item;
	}
	public void setItem(ItemDTO item) {
		this.item = item;
	}
	private int quantity;
	
	private float totalCost;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CartDTO cart;
	
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
	
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "ProductsInCart [itemId=" + itemId + ", quantity=" + quantity + ", totalCost=" + totalCost + "]";
	}
	
	
	
}
