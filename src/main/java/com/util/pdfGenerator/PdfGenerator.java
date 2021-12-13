package com.util.pdfGenerator;

import com.models.BookingDTO;
import com.models.User;

public interface PdfGenerator {
	public String generatePdf(BookingDTO booking,User user) throws Exception;
}
