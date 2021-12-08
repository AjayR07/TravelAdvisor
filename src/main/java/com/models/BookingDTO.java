package com.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class BookingDTO implements Serializable,Cloneable,Comparable<BookingDTO>{
	
	public BookingDTO() {
		super();
	}

	
	public BookingDTO(int userId, Set<ProductsInBooking> products, float totalPrice) {
		super();
		this.userId = userId;
		this.products = products;
		this.totalPrice = totalPrice;
	}


	private static final long serialVersionUID = -8497785486329327199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	private int userId;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "booking")
	private Set<ProductsInBooking> products;
	
	private float totalPrice;

	private static BookingDTO booking;
	
	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Set<ProductsInBooking> getProducts() {
		return products;
	}


	public void setProducts(Set<ProductsInBooking> products) {
		this.products = products;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public static BookingDTO getInstance(int userId, Set<ProductsInBooking> products, float totalPrice) {
		try {
			
			if(booking==null) {
				booking=new BookingDTO( userId,  products, totalPrice);
			}
			else {
				booking=booking.createClone();
				booking.setUserId(userId);
				booking.setProducts(products);
				booking.setTotalPrice(totalPrice);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booking;
	}
	
	public BookingDTO createClone() {
		try {
			return (BookingDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public String toString() {
		return "BookingDTO [bookingId=" + bookingId + ", userId=" + userId + ", products=" + products + ", totalPrice="
				+ totalPrice + "]";
	}


	@Override
	public int compareTo(BookingDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	
}
