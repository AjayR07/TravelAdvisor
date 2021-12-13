package com.util.pdfGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.BookingDTO;
import com.models.User;

public class PdfGenImpl implements PdfGenerator,Serializable{

	
	private static final long serialVersionUID = -6654236686888621494L;
	private String FILE_NAME;
	@Override
	public String generatePdf(BookingDTO booking, User user) throws Exception {
		System.out.println("Creating your PDF....");
		Document document = new Document();
		FILE_NAME="TRIP_AD_"+String.valueOf(1000+booking.getBookingId())+".pdf";
		try {
        	PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));

            //open
            document.open();

            Paragraph p = new Paragraph();
            p.add("e-FIR Filing Process");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            
            Paragraph p2 = new Paragraph();
            p2.add(""); //no alignment
            document.add(p2);
            
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            
            document.add(new Paragraph("Your FIR is Filed.",f));
            PdfPTable table = new PdfPTable(3); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table
     
            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f};
            table.setWidths(columnWidths);
     
            PdfPCell cell1 = new PdfPCell(new Paragraph("Ajay"));
            cell1.setBorderColor(BaseColor.BLUE);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            PdfPCell cell2 = new PdfPCell(new Paragraph("Krishna"));
            cell2.setBorderColor(BaseColor.GREEN);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            PdfPCell cell3 = new PdfPCell(new Paragraph("Thiyo"));
            cell3.setBorderColor(BaseColor.RED);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
     
            //To avoid having the cell border and the content overlap, if you are having thick cell borders
            //cell1.setUserBorderPadding(true);
            //cell2.setUserBorderPadding(true);
            //cell3.setUserBorderPadding(true);
     
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
     
            document.add(table);
           
            //close
            document.close();
            System.out.println("Done");
         
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	System.out.println("Hurrah!  PDF Generated successfully.....");
	
		return FILE_NAME;
	}

}
