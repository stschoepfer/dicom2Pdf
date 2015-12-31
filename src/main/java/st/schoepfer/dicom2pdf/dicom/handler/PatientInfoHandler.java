/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.Tag;


/**
 *
 * @author Stefan
 */
public class PatientInfoHandler  extends AtrributeHandler{
    File theDicomFile;

    public PatientInfoHandler(File aDicomFile) {
        super(aDicomFile);
    }
	

        
    public String getPatientIDFromDicom() {
        final int TAG = 1048608;      
        return super.dmObject.getString(TAG);   
    }
    
    public String getPatientNameFromDicom() {
        final int TAG = 1048592;;
        return super.dmObject.getString(TAG);      
    }

    public Date getPatientBirthdateFromDicom() throws IOException {
        final int TAG = 1048624;
        return super.dmObject.getDate(TAG);
    }            

	
}
