package com.util.sms;
import java.io.Serializable;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SmsSenderImpl implements SmsSender,Serializable {

	private static final long serialVersionUID = 1L;
//	public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
//    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
    public static final String ACCOUNT_SID = "AC391bfa8b15723f14e0fffe48db054188";
    public static final String AUTH_TOKEN = "ccd7115a683d3fcafc14bf261c6cb5e0";
	@Override
	public void sendSMS(String PhoneNum, String code) throws Exception {
		// TODO Auto-generated method stub
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message msg= Message.creator(new com.twilio.type.PhoneNumber("+91"+PhoneNum),new com.twilio.type.PhoneNumber("+13187028899"), "Your One Time Password is "+code).create();
		System.out.println(msg.getSid());
		System.out.println("SMS sent successfully");
	}
	
}