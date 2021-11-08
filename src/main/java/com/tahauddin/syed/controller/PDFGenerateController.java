package com.tahauddin.syed.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lowagie.text.DocumentException;
import com.tahauddin.syed.service.PDFGenerateService;

/**
 * 
 * @author Syed Tahauddin
 *
 */
@Controller
public class PDFGenerateController {
	
	@Autowired
	private PDFGenerateService pdfGenerateService;
	

	@GetMapping("/pdf/download")
	public void pdfDownload(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		
		DateFormat simpleDateFormat = new SimpleDateFormat();
		String currentDateAndTime = simpleDateFormat.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment: filename=pdf_" + currentDateAndTime + ".pdf";
		
		response.setHeader(headerKey, headerValue);
		
		pdfGenerateService.generatePdf(response);
	}
}
