package com.services;

import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BookingDTO;
import com.models.ItemDTO;
import com.models.ProductsInBooking;
import com.models.ProductsInCart;
import com.repositories.BookingRepo;
import com.repositories.CartRepo;
import com.repositories.ProductsInCartRepo;

@Service
@Transactional
public class BookingService {
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private ItemService itemRepo;

	
	@Autowired
	private CartRepo cartRepo;
	
	
	@Autowired
	private ProductsInCartRepo productInCartRepo;

	public BookingRepo getBookingRepo() {
		return bookingRepo;
	}

	public void setBookingRepo(BookingRepo bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	public ItemService getItemRepo() {
		return itemRepo;
	}

	public void setItemRepo(ItemService itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	public CartRepo getCartRepo() {
		return cartRepo;
	}

	public void setCartRepo(CartRepo cartRepo) {
		this.cartRepo = cartRepo;
	}
	
	
	
	
	
	
	
	
	
	
	public List<BookingDTO> getMyBookings(int userId) {
		
		List<BookingDTO> bookings= bookingRepo.findByUserId(userId);
		if(bookings!=null) {
			for(BookingDTO booking:bookings) {
				for(ProductsInBooking product:booking.getProducts()) {
					String base64Encoded =  Base64.getEncoder().encodeToString(product.getItemImage());
					product.setBase64imageFile(base64Encoded);
				}
			}
			
		}
		return bookings;
	}

	
	public String generateBooking(int userId,int[] cartProducts, int total) {
		Set<ProductsInBooking> products=new TreeSet<ProductsInBooking>();
		try {
			
		
		BookingDTO book=BookingDTO.getInstance(userId, (float)total/100);
		for(int i:cartProducts) {
			ProductsInCart cartProd=productInCartRepo.findById(i).orElse(null);
			ItemDTO item=itemRepo.findItemById(cartProd.getItemId());
			products.add(new ProductsInBooking(item.getItemId(), item.getItemName(), item.getItemDesc(), item.getItemImage(), item.getItemCategory(),item.getUnit(), item.getItemPrice(),  cartProd.getQuantity(), cartProd.getTotalCost(),book));
			productInCartRepo.deleteById(i);
		}
		book.setProducts(products);
		
		bookingRepo.save(book);
		return "Your Booking is Successfull!";
		}
		catch(Exception e) {
			return "Please try again!";
		}
		
	}

	


}
