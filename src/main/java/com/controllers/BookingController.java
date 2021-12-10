package com.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import com.services.BookingService;
import com.services.MyUserDetailsService;

@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private MyUserDetailsService userService;

	public BookingService getBookingService() {
		return bookingService;
	}


	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	
	 public MyUserDetailsService getUserService() {
		return userService;
	}


	public void setUserService(MyUserDetailsService userService) {
		this.userService = userService;
	}


	@GetMapping(value="/booking")
	public void bookGet(HttpServletRequest request,HttpServletResponse response) throws Exception {
		 RazorpayClient client=null;
		 String orderId=null;
		 try {
			  client=new RazorpayClient("rzp_test_xTD1haela80DyW","XiPjbzgedOK6dZeWJOapAj6R");
			  JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", request.getParameter("amount")); // amount in the smallest currency unit
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");
			  orderRequest.put("payment_capture", true);
			  
			  Order order = client.Orders.create(orderRequest);
			  System.out.println(order);
			  orderId=order.get("id");
			} catch (RazorpayException e) {
			  // Handle Exception
			  System.out.println(e.getMessage());
			}
		 response.getWriter().append(orderId);
	}
	 
	 
	 @PostMapping(value="/booking")
		public void bookPost(HttpServletRequest request,HttpServletResponse response) throws Exception {
			 RazorpayClient client=null;
			 String orderId=null;
			 try {
				  client=new RazorpayClient("rzp_test_xTD1haela80DyW","XiPjbzgedOK6dZeWJOapAj6R");
				  JSONObject orderRequest = new JSONObject();
				  orderRequest.put("razorpay_payment_id",request.getParameter("razorpay_paymeny_id"));
				  orderRequest.put("razorpay_order_id",request.getParameter("razorpay_order_id"));
				  orderRequest.put("razorpay_signature",request.getParameter("razorpay_signature"));
				  
				  boolean SigRes=Utils.verifyPaymentSignature(orderRequest, "XiPjbzgedOK6dZeWJOapAj6R");
				  if(SigRes) {
					  response.getWriter().append("Payment Successfull and Signature Verified");
				  }
				  else {
					  response.getWriter().append("Payment Failed and Signature Not Verified");
				  }
				  

				} catch (RazorpayException e) {
				  // Handle Exception
				  System.out.println(e.getMessage());
				}
			 
		}
	 
	 @PostMapping(value="/addTobookingDetails")
		public void saveBooking(String json,HttpServletResponse response, Principal principal) throws Exception {
		 JSONObject jsonObject = null;
		    try {
		        jsonObject = new JSONObject(json);
		    } catch(JSONException _instance) {
		        System.out.println("Error in JSON");
		    }
		    
		    int totalPrice=jsonObject.getInt("total");
		    JSONArray arr = jsonObject.getJSONArray("products");
		    int[] products = new int[arr.length()];
		     for (int i = 0; i < arr.length(); i++) {
		        products[i] = (int)arr.get(i);
		     }
		    String res=bookingService.generateBooking(userService.getUser(principal.getName()).getUid(),products, totalPrice);
		    response.getWriter().append(res);

			 
		}

}
