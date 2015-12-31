/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;


/**
 *
 * @author Stefan
 */
public class PatientInfoHandler {
    	File theDicomFile;
	
        /**
         * 
         * @param dicomFilePath
         * @throws FileNotFoundException 
         */
	public PatientInfoHandler(String dicomFilePath) throws FileNotFoundException {
		this.theDicomFile = new File(dicomFilePath);
		
		if (!theDicomFile.exists()) {
			throw new FileNotFoundException();
		}
		
		ImageIO.scanForPlugins();
	}
        

	
}
