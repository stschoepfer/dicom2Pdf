/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dcm4che3.data.Tag;
import st.schoepfer.dicom2pdf.dicom.entities.Patient;



/**
 *
 * @author Stefan
 */
public class PatientInfoHandler  extends AtrributeHandler{

    public PatientInfoHandler(File aDicomFile) {
        super(aDicomFile);
    }
	
    public String getPatientIDFromDicom() {
        final int TAG = Tag.PatientID;      
        return super.getElementAsString(TAG);   
    }
    
    public String getPatientNameFromDicom() {
        final int TAG = Tag.PatientName;
        return super.getElementAsString(TAG);      
    }

    public Date getPatientBirthdateFromDicom() throws IOException {
        final int TAG = Tag.PatientBirthDate;
        return super.getElementAsDate(TAG);
    }
    
    public Patient getPatient() {
        Patient pat = new Patient(this.getPatientIDFromDicom());
        
        try {
            pat.setBirthdate(this.getPatientBirthdateFromDicom());
        } catch (IOException ex) {
            Logger.getLogger(PatientInfoHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        pat.setPatientNameDemilited(this.getPatientNameFromDicom(), "^", 0);
        
        return pat;
    }

	
}
