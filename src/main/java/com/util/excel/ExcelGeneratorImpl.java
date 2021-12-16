package com.util.excel;

import java.io.Serializable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.BookingDTO;
import com.models.ProductsInBooking;
import com.services.BookingService;

@Service
public class ExcelGeneratorImpl implements ExcelGenerator,Serializable {
	
	@Autowired
	private BookingService bookingService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ExcelGeneratorImpl() {
		 
	}
	@Override
	public void generateExcel(HttpServletResponse response) throws Exception {
		HSSFRow row;
		System.out.println("Creating your Excel....");
		try   
		{  
			
		
		//creating an instance of HSSFWorkbook class  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//invoking creatSheet() method and passing the name of the sheet to be created   
		HSSFSheet sheet = workbook.createSheet("Bookings");
		
		//creating the 0th row using the createRow() method  
		HSSFRow rowhead = sheet.createRow((short)0);  
		
		//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
		rowhead.createCell(0).setCellValue("Booking Id");  
		rowhead.createCell(1).setCellValue("Total Price");  
		rowhead.createCell(2).setCellValue("User Id");  
	 
		
		
		HSSFSheet sheet2 = workbook.createSheet("Booking_Orders");
		
		//creating the 0th row using the createRow() method  
		HSSFRow rowhead2 = sheet2.createRow((short)0);  
		
		//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
		rowhead2.createCell(0).setCellValue("Booking Id");  
		rowhead2.createCell(1).setCellValue("Item Id");  
		rowhead2.createCell(2).setCellValue("Item Name"); 
		rowhead2.createCell(3).setCellValue("Item Description");  
		rowhead2.createCell(4).setCellValue("Unit");  
		
		rowhead2.createCell(5).setCellValue("Total Cost"); 
		int rowCount2 = 1;
		int rowCount = 1;
		
		
		for(BookingDTO booking:bookingService.getAllBookings()) {
			row = sheet.createRow((short)rowCount++);  
			row.createCell(0).setCellValue(booking.getBookingId());  
			row.createCell(1).setCellValue(booking.getTotalPrice());  
			row.createCell(2).setCellValue(booking.getUserId());  
			for(ProductsInBooking product: booking.getProducts()) {
				row = sheet2.createRow((short)rowCount2++);  
				row.createCell(0).setCellValue(booking.getBookingId());  
				row.createCell(1).setCellValue(product.getItemId());  
				row.createCell(2).setCellValue(product.getItemName());  
				row.createCell(3).setCellValue(product.getItemDesc());  
				row.createCell(4).setCellValue("Rs."+product.getItemPrice()+"/"+product.getUnit());
				row.createCell(5).setCellValue("Rs."+product.getTotalCost());  
				  
			}
		}
		ServletOutputStream  fileOut = response.getOutputStream(); 
		workbook.write(fileOut);  
		//closing the Stream  
		workbook.close();
        
        fileOut.close();  
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		
		
		System.out.println("Hurrah! Excel Generated successfully.....");
		
		
	}
	
}