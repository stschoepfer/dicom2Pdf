/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;



/**
 *
 * @author Stefan
 */
public class ImageHandler {
         
    File theDicomFile;
    
         /**
         * 
         * @param aDicomFile 
         */
	public ImageHandler(File aDicomFile) {
		this.theDicomFile = aDicomFile;
		ImageIO.scanForPlugins();
                
	}
    
        /**
         * 
         * @return
         * @throws IOException 
         */
	public BufferedImage getBufferdImageFile() throws IOException {
		BufferedImage myJpegImage = null;
		ImageInputStream iis = null;
		ImageIO.scanForPlugins();
                
		Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("dicom");
                ImageReader reader = (ImageReader) iter.next();
                ImageReadParam param = (ImageReadParam) reader.getDefaultReadParam();

                
		iis = ImageIO.createImageInputStream(theDicomFile);
		reader.setInput(iis, false);   
		myJpegImage =  reader.read(0, param); 
		
		return myJpegImage;
	}
	
        /**
         * 
         * @param path
         * @param filePrefix 
         */
	public void SaveImagesAsJPEG(String path, String filePrefix) {
		
		BufferedImage myJpegImage;
		ImageInputStream iis = null;
		String strFullPath = path + "\\" + filePrefix + ".jpg";
		
		
		Iterator<ImageReader> iter =  ImageIO.getImageReadersByFormatName("dicom");
		ImageReader reader = (ImageReader) iter.next();
		ImageReadParam param = (ImageReadParam) reader.getDefaultReadParam();
		
		try {    
			iis = ImageIO.createImageInputStream(theDicomFile);
			reader.setInput(iis, false);   
			myJpegImage =  reader.read(0, param); 
			// iis.close();
			
			if (myJpegImage == null) 
			{
			   throw new IllegalStateException("Dicom kann nicht gelesen werden");
			}
			
			File myJpegFile = new File(strFullPath);   
			OutputStream output = new BufferedOutputStream(new FileOutputStream(myJpegFile));
			ImageIO.write(myJpegImage, "jpeg", output);
			output.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
	
			try {
				iis.close();
			} catch (Exception e) {
				// Ignore
			}
		}
	}
}
