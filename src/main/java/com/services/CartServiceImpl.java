package com.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.CartDTO;
import com.models.ItemDTO;
import com.models.ProductsInCart;
import com.repositories.CartRepo;
import com.repositories.ItemDAO;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepo cart;
	
	@Autowired
	private ItemDAO item;
	
	public CartRepo getCart() {
		return cart;
	}

	public ItemDAO getItem() {
		return item;
	}

	public void setItem(ItemDAO item) {
		this.item = item;
	}

	public void setCart(CartRepo cart) {
		this.cart = cart;
	}
	
	@Override
	public CartDTO getMyCart(int userId) {
		
		CartDTO mycart=cart.findByUserId(userId);
		if(mycart==null) {
			mycart=CartDTO.getInstance(userId,null,0);
		}
		else if(mycart!=null) {
			for(ProductsInCart product:mycart.getProducts()) {
//				System.out.println(product.getItemId());
				product.setItem(item.findById(product.getItemId()).orElse(null));
			}
		}
		return mycart;
	}

	@Override
	public CartDTO addToCart(int userId,int productId, int count) {
		CartDTO mycart=this.getMyCart(userId);
		ItemDTO cart_item=item.findById(productId).orElse(null);
		float price=cart_item.getItemPrice()*count;
		ProductsInCart pic=new ProductsInCart(productId,count,price,mycart);
		Set<ProductsInCart> products=mycart.getProducts();
		products.add(pic);
		mycart.setProducts(products);
		mycart.setTotalPrice(mycart.getTotalPrice()+price);
		cart.save(mycart);
		return null;
	}

	
	

}
