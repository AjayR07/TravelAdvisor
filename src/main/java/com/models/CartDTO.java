package com.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartDTO implements Serializable,Cloneable,Comparable<CartDTO>{
	
	public CartDTO() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8497785486329327199L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	private int userId;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "cart")
	private Set<ProductsInCart> products;
	
	private float totalPrice;

	private static CartDTO cart;
	
	public int getCartId() {
		return cartId;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<ProductsInCart> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductsInCart> products) {
		this.products = products;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", userId=" + userId + ", products=" + products + ", totalPrice="
				+ totalPrice + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, products, totalPrice, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		return cartId == other.cartId && Objects.equals(products, other.products)
				&& Float.floatToIntBits(totalPrice) == Float.floatToIntBits(other.totalPrice) && userId == other.userId;
	}

	@Override
	public int compareTo(CartDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}

	private CartDTO(int userId, Set<ProductsInCart> products, float totalPrice) {
		super();
		
		this.userId = userId;
		this.products = products;
		this.totalPrice = totalPrice;
	}

	public static CartDTO getInstance(int userId, Set<ProductsInCart> products, float totalPrice) {
		try {
			
			if(cart==null) {
				cart=new CartDTO( userId,  products, totalPrice);
			}
			else {
				cart=cart.createClone();
				cart.setUserId(userId);
				cart.setProducts(products);
				cart.setTotalPrice(totalPrice);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cart;
	}
	
	public CartDTO createClone() {
		try {
			return (CartDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
}
