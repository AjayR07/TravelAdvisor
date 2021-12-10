package com.services;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
	private ItemService item;
	
	public CartRepo getCart() {
		return cart;
	}


	public void setCart(CartRepo cart) {
		this.cart = cart;
	}
	
	@Override
	public CartDTO getMyCart(int userId) {
		
		CartDTO mycart=cart.findByUserId(userId);
		if(mycart==null) {
			
			mycart=CartDTO.getInstance(userId,new TreeSet<ProductsInCart>(),0);
		}
		else if(mycart!=null) {
			for(ProductsInCart product:mycart.getProducts()) {
				product.setItem(item.findItemById(product.getItemId()));
			}
		}
		return mycart;
	}

	@Override
	public String addToCart(int userId,int productId, int count) {
		CartDTO mycart=this.getMyCart(userId);
		ItemDTO cart_item=item.findItemById(productId);
		float price=cart_item.getItemPrice()*count;
		ProductsInCart pic=new ProductsInCart(productId,count,price,mycart);
		Set<ProductsInCart> products=mycart.getProducts();
		int isPresent=0;
		for(ProductsInCart product: products) {
			if(product.getItemId()==productId) {
				product.setQuantity(count);
				product.setTotalCost(price);
				isPresent=1;
				break;
			}
		}
		if(isPresent!=1) {
			products.add(pic);
		}
		Double total=products.stream().mapToDouble(ProductsInCart::getTotalCost).sum();
	
		mycart.setProducts(products);
		mycart.setTotalPrice(total.floatValue());
		cart.save(mycart);
		return "Product Added to Cart Successfully";
	}

	@Override
	public int getCartProductsCount(int userId) {
		CartDTO mycart=this.getMyCart(userId);
		
		return mycart.getProducts().size();
	}


	

}
