package com;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.services.InitService;


@SpringBootApplication(scanBasePackages = {"com"},exclude = HibernateJpaAutoConfiguration.class)
public class TravelAdvisorApplication {
	

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext ctx=  SpringApplication.run(TravelAdvisorApplication.class, args);
//		ctx.getBean("initService",InitService.class).initializeEnv();
}
}
 