package model;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFPrinter {
    
    public static void printCwToPdf (java.awt.Image awtImage, String filePath, String docTitle) throws DocumentException, IOException{

	Document doc = new Document();
	doc.addTitle(docTitle);
	doc.addCreationDate();
	doc.setMargins(0, 0, 0, 0);
	PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(
		filePath));
	doc.open();
	Image iTextImage = Image.getInstance(writer, awtImage, 1);
	iTextImage.setAlignment(0);
	
	doc.add(iTextImage);
	doc.close();


    }
    
    
    public static java.awt.Image getImageFromPanel(Component component) {
	System.out.println(component.getSize().getWidth());
	BufferedImage image = new BufferedImage(component.getWidth(),
		component.getHeight(), BufferedImage.TYPE_INT_RGB);
	component.paint(image.getGraphics());
	return image;
    }
}
