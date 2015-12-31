/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
// import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

/**
 *
 * @author Stefan
 */
public class PdfFileHandler {
	
	private final int INITIAL_VALUE = 0;
	private final int ERROR_VALUE = -1;
	private final String IMAGE_FOLDER;
	PDDocument aFile;
	String FileName;
	
	public PdfFileHandler(String aFilename, String aImageFolder) {
		this.FileName = aFilename;
		this.IMAGE_FOLDER = aImageFolder;
	}
	
	public String getFileName(){
		return this.FileName;
	}
	
	public void addTextAtPosition(String newText, int x, int y) {
		this.loadPDFFile();
        PDFont font = PDType1Font.HELVETICA_BOLD;
        float fontSize = 30.0f;
        
		try {
			PDPageContentStream stream = new PDPageContentStream(this.aFile, this.getPageByNumber(1), true, true);
			
			stream.beginText();
			stream.setFont(font, fontSize);
			stream.setNonStrokingColor(Color.GREEN);
			stream.moveTextPositionByAmount(x, y);
			stream.drawString(newText);
			stream.endText();
			stream.close();
			
			
			this.aFile.save(this.getFileName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			this.closePDFFile();	
		}
		
	}
	
	private void loadPDFFile() {
		// Laded die gewünschte Datei.
		// Wenn dabei ein Fehler auftritt wird ein neues Dokument mit einer leeren Seite geladen.
		try {
			this.aFile = PDDocument.load(this.FileName);
		} catch(Exception ex) {
			this.aFile = new PDDocument();
			this.aFile.addPage(new PDPage());
		}
	}
	
	private void closePDFFile() {
		
		if (this.aFile!=null) {
			try {
				this.aFile.close();
				this.aFile = null;
			} catch(Exception ex) {
				
			}
		}
	
	}
	
	public int CountPages() {
		int pageCount = this.INITIAL_VALUE;
		this.loadPDFFile();
		
		try {
			pageCount = this.aFile.getNumberOfPages();
		}
		catch(Exception e) {
			pageCount = this.ERROR_VALUE;
		}
		
		this.closePDFFile();
		return pageCount;
	}
	
	/**
	 * 
	 * @return
	 */
	public float SizeHeight(){
		float sizeHeight = this.INITIAL_VALUE;
		
		this.loadPDFFile();
		try {
			sizeHeight = this.getRect().getHeight();
		} catch(Exception exp) {
			sizeHeight = this.ERROR_VALUE;
		}
		this.closePDFFile();
		
		return sizeHeight;
		
	}
	
	public float SizeWidth(){
		float sizeWidth = this.INITIAL_VALUE;
		
		this.loadPDFFile();
		
		try {
			sizeWidth = this.getRect().getWidth();
		} catch(Exception exp) {
			sizeWidth = this.ERROR_VALUE;
		}
		this.closePDFFile();
		
		return sizeWidth;
	}
	
	private PDRectangle getRect(){
		PDRectangle pageSize = null;
		
		try {
			PDPage firstPage = (PDPage)this.aFile.getDocumentCatalog().getAllPages().get(0);
			pageSize = firstPage.findMediaBox();
		}
		catch(Exception exc) {
			pageSize = null;
		}
		
		return pageSize;
				
	}
	
	public PDPage getPageByNumber(int pageNumber) {
		int lastPage = this.INITIAL_VALUE;
		int realPosition = pageNumber -1;
		lastPage = this.aFile.getDocumentCatalog().getAllPages().size() - 1;
		PDPage returnPage = null;

		if (lastPage<0) {
			  throw new NullPointerException("There are no pages in the PDF document");
		}		
		else if (realPosition > lastPage) {
		  throw new ArrayIndexOutOfBoundsException("Maximum number of Pages is: " + Integer.toString(lastPage+1));
		}
		else {
			try {
				returnPage = (PDPage)this.aFile.getDocumentCatalog().getAllPages().get(realPosition);
			} catch(Exception exp) {
				returnPage = null;
			}
		}
		
		return returnPage;
		
	}

	public void addBufferedImage(BufferedImage buffImg, int page, int x, int y) {
		// generate Image of Code
		PDXObjectImage xImage = null;
		
		if (buffImg == null) {
			throw new NullPointerException("Can't generate barcode image");
		}
		else {
			this.loadPDFFile();
			
			try {
				
				xImage = new PDJpeg(aFile, buffImg);
				PDPageContentStream stream = new PDPageContentStream(this.aFile, this.getPageByNumber(page), true, true);
				
		        //create a new outStream
		        stream.drawImage(xImage, x, y);
		        stream.close();
				
		        this.aFile.save(this.getFileName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (COSVisitorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				this.closePDFFile();
			}
		}
	}

}
