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
public class ProductsInBooking implements Serializable,Comparable<ProductsInBooking>,Cloneable {

	public ProductsInBooking() {
		super();
	}
	
	
	public ProductsInBooking(int itemId, int quantity, float totalCost, BookingDTO booking) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.booking = booking;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingProductId;
	
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
	private BookingDTO booking;
	
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
	public int compareTo(ProductsInBooking o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String toString() {
		return "ProductsInBooking [bookingProductId=" + bookingProductId + ", itemId=" + itemId + ", item=" + item
				+ ", quantity=" + quantity + ", totalCost=" + totalCost + ", booking=" + booking + "]";
	}
	

	
	
	
}
