package com.tahauddin.syed.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PDFGenerateService {

	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(24);

		Paragraph paragraph = new Paragraph();
		paragraph.add("This is a Title");
		paragraph.setFont(font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		Font font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font2.setSize(18);

		Paragraph paragraph2 = new Paragraph();
		paragraph2.add("This is a Paragraph..");
		paragraph2.setFont(font2);
		paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph);
		document.add(paragraph2);

		document.close();

	}

}
