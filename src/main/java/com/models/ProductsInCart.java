package com.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProductsInCart implements Serializable,Comparable<ProductsInCart>,Cloneable {

	public ProductsInCart() {
		super();
	}
	
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
	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
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
	@Override
	public int compareTo(ProductsInCart o) {
		// TODO Auto-generated method stub
		return this.cartProductId>o.cartProductId?1:0;
	}

	
	
	
}
