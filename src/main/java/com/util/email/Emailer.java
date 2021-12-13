package com.util.email;

import java.io.Serializable;

import com.models.BookingDTO;
import com.models.User;

public interface Emailer extends Serializable  {
	public void sendEmail(BookingDTO booking,User user,String attachmentPath) throws Exception;

}