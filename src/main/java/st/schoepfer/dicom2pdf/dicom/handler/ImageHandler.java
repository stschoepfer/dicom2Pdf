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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.dcm4che3.imageio.codec.ImageReaderFactory;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;

/**
 *
 * @author Stefan
 */
public class ImageHandler {
         
    File theDicomFile;
    ImageInputStream iis = null;
    
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
		String strFullPath = path + "\\" + filePrefix + ".jpg";
		
		try {    
                        myJpegImage =  this.getBufferdImageFile();
			
			
			if (myJpegImage == null) 
			{
			   throw new IllegalStateException("Dicom kann nicht gelesen werden");
			}
			
			File myJpegFile = new File(strFullPath);   
			OutputStream output;
                        output = new BufferedOutputStream(new FileOutputStream(myJpegFile));
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
