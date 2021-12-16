package com.util.excel;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;


public interface ExcelGenerator {
	public void generateExcel(HttpServletResponse response) throws Exception;
}
