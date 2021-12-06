package com.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.models.ItemDTO;
import com.repositories.ItemDAO;




@Service
@Transactional
public class ItemService {
	
	@Autowired
	ItemDAO itemDAO;
	

	public ItemDAO getItemDAO() {
		return itemDAO;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
	public List<ItemDTO> listItems() {
		List<ItemDTO> items=itemDAO.findAll();
		for(ItemDTO item:items) {
		
	        String base64Encoded =  Base64.getEncoder().encodeToString(item.getItemImage());
	        item.setBase64imageFile(base64Encoded);
			
		}
		return items;
	}
	
	
	public ItemDTO findItemById(int id) {
		ItemDTO item=itemDAO.findById(id).orElse(null);
		String base64Encoded =  Base64.getEncoder().encodeToString(item.getItemImage());
        item.setBase64imageFile(base64Encoded);
		
		return item;
		
	}
	
	public static byte[] imgToBlob(String path) {
			
			BufferedImage bimage;
			ByteArrayOutputStream baos =null;
			try {
				bimage = (BufferedImage)ImageIO.read(new File(path));
				baos = new ByteArrayOutputStream();
				ImageIO.write(bimage, "jpg", baos);
			    
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(baos.toByteArray());
			return baos.toByteArray();
	       
		}
	public void addItem() {

		ItemDTO item=ItemDTO.getInstance("Scuba Diving","The Scuba diving organizers in Goa offer the experience at a very attractive price and prioritize safety. For all those looking to get high, go scuba diving and feel the high like never before.\r\n"+"An experienced PADI instructor will guide you to ensure that you carry out the Grand Island Goa scuba diving session with safety\r\n"
				+ "Try your hands at some of the most fun-filled water sports that include Scuba Diving, Parasailing, Banana ride, Speed Boat ride, Bumper ride, Jetski, etc\r\n"
				+ "Grab an opportunity to capture amazing marine creatures and environments by underwater photography and videography\r\n"
				+ "Get ready for a 15-minute underwater Scuba diving at Grand Island and spend a fun-filled time with your friends",imgToBlob("assets/scuba_1.jpg"), 1,"hour", 1999, 30);
		itemDAO.save(item);
	}
	
	
	
}
