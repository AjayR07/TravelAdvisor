package com.models;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProductsInBooking implements Serializable,Comparable<ProductsInBooking>,Cloneable {

	public ProductsInBooking() {
		super();
	}
	
	
	


	public ProductsInBooking(int itemId, String itemName, String itemDesc, byte[] itemImage, int itemCategory,
			String unit, float itemPrice, int quantity, float totalCost,BookingDTO booking) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemImage = itemImage;
		this.itemCategory = itemCategory;
		this.unit = unit;
		this.itemPrice = itemPrice;
		
		this.quantity = quantity;
		this.totalCost = totalCost;
		this.booking=booking;
	}





	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingProductId;
	
	private static final long serialVersionUID = 1726984765703163766L;
	private int itemId;
	private String itemName;
	
	
	@Lob
	private String itemDesc;

	@Lob
    @Column(name = "itemImage", columnDefinition="LONGBLOB")
	private byte[] itemImage;
	
	private int itemCategory;
	
	private String unit;
	
	private float itemPrice;
	
	
	
	private int quantity;
	
	private float totalCost;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private BookingDTO booking;
	
	@Transient
	private String base64imageFile;
	public String getBase64imageFile() {
		return base64imageFile;
	}
	public void setBase64imageFile(String base64imageFile) {
		this.base64imageFile = base64imageFile;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	
	public int getBookingProductId() {
		return bookingProductId;
	}





	public void setBookingProductId(int bookingProductId) {
		this.bookingProductId = bookingProductId;
	}





	public String getItemName() {
		return itemName;
	}





	public void setItemName(String itemName) {
		this.itemName = itemName;
	}





	public String getItemDesc() {
		return itemDesc;
	}





	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}





	public byte[] getItemImage() {
		return itemImage;
	}





	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}





	public int getItemCategory() {
		return itemCategory;
	}





	public void setItemCategory(int itemCategory) {
		this.itemCategory = itemCategory;
	}





	public String getUnit() {
		return unit;
	}





	public void setUnit(String unit) {
		this.unit = unit;
	}





	public float getItemPrice() {
		return itemPrice;
	}





	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}










	public BookingDTO getBooking() {
		return booking;
	}





	public void setBooking(BookingDTO booking) {
		this.booking = booking;
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
		return "ProductsInBooking [bookingProductId=" + bookingProductId + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemDesc=" + itemDesc + ", itemImage=" + Arrays.toString(itemImage) + ", itemCategory="
				+ itemCategory + ", unit=" + unit + ", itemPrice=" + itemPrice +  ", quantity=" + quantity + ", totalCost=" + totalCost + "]";
	}


	

	
	
	
}
