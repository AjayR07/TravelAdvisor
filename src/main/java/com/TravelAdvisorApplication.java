package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.models.ItemDTO;
import com.services.ItemService;

@SpringBootApplication(scanBasePackages = {"com"},exclude = HibernateJpaAutoConfiguration.class)
public class TravelAdvisorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=  SpringApplication.run(TravelAdvisorApplication.class, args);
//		ItemService itemService=ctx.getBean("itemService",ItemService.class);
//		itemService.addItem();
//		for(ItemDTO item:itemService.listItems()) {
//		System.out.println(item.getItemName() +" : "+item.getItemPrice());
//	}
	}

}
 