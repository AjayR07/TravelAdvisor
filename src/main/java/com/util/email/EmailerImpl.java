package com.util.email;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.jsoup.Jsoup;

import com.models.BookingDTO;
import com.models.User;

public class EmailerImpl implements Emailer {
	private static final long serialVersionUID = 2576045837054436091L;

	public EmailerImpl() {
		 
	}
	public void sendEmail(BookingDTO booking,User user,String attachmentPath) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processing to send Email....");
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		
		String username="ajayr022991@gmail.com";
		String password="ajay2001";
		
		Session session=Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(username,password); 
			    } 
		});
		
		Message msg=prepareMessage(session,username,user.getMail(),attachmentPath,booking);
		System.out.println(msg);
		Transport.send(msg);
		System.out.println("Hurrah!  Email Send successfully.....");
		
		
	}
	
	private static Message prepareMessage(Session session,String username,String recipient,String path,BookingDTO booking) {
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			message.setSubject("Trip Ad Service Booking");
			  
 
		    Multipart multipart = new MimeMultipart(); 
		    MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();
		    try {
		    	
		    	
		    	
                File f =new File(path);
                System.out.println(f.getAbsolutePath()+" "+f.getName());
               attachmentPart.attachFile(f);
               
              // textPart.setText("Your Booking is Successful. Here is your booking ID: "+booking.getBookingId());
               textPart.setText(Jsoup.parse(new File("email.html"), "UTF-8").toString());
               textPart.setHeader("Content-Type", "text/html");
               multipart.addBodyPart(textPart);
               multipart.addBodyPart(attachmentPart);
           } catch (IOException e) {
               e.printStackTrace();
           }
		     
			message.setContent(multipart);    
			return message;
		} catch (Exception e) {
			e.printStackTrace(); 
			return null;
		}
	}
}