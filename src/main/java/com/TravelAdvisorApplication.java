package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.models.CartDTO;
import com.models.ProductsInCart;
import com.repositories.BookingRepo;
import com.services.CartService;

@SpringBootApplication(scanBasePackages = {"com"},exclude = HibernateJpaAutoConfiguration.class)
public class TravelAdvisorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=  SpringApplication.run(TravelAdvisorApplication.class, args);
//		ItemService itemService=ctx.getBean("itemService",ItemService.class);
//		itemService.addItem();
//		for(ItemDTO item:itemService.listItems()) {
//		System.out.println(item.getItemName() +" : "+item.getItemPrice());
//	}
//		
//		CartService cartService=ctx.getBean(CartService.class);
//		CartDTO cart=cartService.getMyCart(1);
//		for(ProductsInCart p:cart.getProducts()) {
//			System.out.println(p);
//		}
		
		
	}

}
 