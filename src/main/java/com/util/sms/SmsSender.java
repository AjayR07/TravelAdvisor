package com.util.sms;

public interface SmsSender {
	public void sendSMS(String PhoneNum, String code) throws Exception; 
}
