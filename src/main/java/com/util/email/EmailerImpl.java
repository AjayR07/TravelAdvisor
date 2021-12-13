package com.util.email;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
		
		Message msg=prepareMessage(session,username,user.getMail(),attachmentPath);
		
		Transport.send(msg);
		System.out.println("Hurrah!  Email Send successfully.....");
		
		
	}
	
	private static Message prepareMessage(Session session,String username,String recipient,String path) {
		Message message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			message.setSubject("FIR record is Filed...");
			
		    BodyPart messageBodyContent= new MimeBodyPart();  
		    messageBodyContent.setText("This is message body");  
		      
		    //creating new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyAttachment = new MimeBodyPart();  
		  
		    
		    DataSource source = new FileDataSource(path);  
		    
		    messageBodyAttachment.setDataHandler(new DataHandler(source));  
		    messageBodyAttachment.setFileName("Book XML File");  
		     
		     
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyContent);  
		    multipart.addBodyPart(messageBodyAttachment);  
		  
		     
		    message.setContent(multipart);    
			message.setText("Your application for FIR filing is processed and generated successfully. FIR Duplicate Copy is attached here. Needed Action will be taken ASAP.");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}