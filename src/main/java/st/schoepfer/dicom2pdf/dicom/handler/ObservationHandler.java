/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;


import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import st.schoepfer.dicom2pdf.dicom.entities.Observation;


/**
 *
 * @author Stefan
 */
public class ObservationHandler extends AtrributeHandler{

    public ObservationHandler(File aDicomFile) {
        super(aDicomFile);
    }
    

     public String getManufacturFromDicom() {
         final int TAG = 524400;      
         return super.dmObject.getString(TAG); 
     }

     public String getModalityFromDicom() {
         final int TAG = 524384;
         return super.dmObject.getString(TAG);
     }     
     
     public String getThreatingDoctorFromDicom() {
         final int TAG = 528496;
         return super.dmObject.getString(TAG);
     }
     
     public String getClinicFromDicom() {
         final int TAG = 524416;
         return super.dmObject.getString(TAG);
     }
     
     public Date getStudyDateFromDicom() {
         final int TAG = 524320;
         return super.dmObject.getDate(TAG);
     }
     
     public Date getStudyTimeFromDicom() {
         final int TAG = 524336;
         return super.dmObject.getDate(TAG);
     }
     
     public String getStudyIDFromDicom() {
         final int TAG = 2097168;
         return super.dmObject.getString(TAG);
     }
     
     public String getCaseIDFromDicom() {
         final int TAG = 3670032;
        try {
            super.affichageDicomItem(super.dmObject, TAG);
        } catch (IOException ex) {
            Logger.getLogger(ObservationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         return super.dmObject.getString(TAG);
     }
     
     public Observation getObservation() {

         Calendar hr = Calendar.getInstance();
         hr.setTime(this.getStudyTimeFromDicom());
         
         Calendar cal = Calendar.getInstance();
         cal.setTime(this.getStudyDateFromDicom());
         cal.set(cal.YEAR, cal.MONTH, cal.DATE, hr.HOUR, hr.MINUTE, hr.SECOND);
         
         
         Observation obs = new Observation(this.getStudyIDFromDicom(), cal.getTime());
         obs.setManufactur(this.getManufacturFromDicom());
         obs.setModality(this.getModalityFromDicom());
         obs.setThreatingDoctor(this.getThreatingDoctorFromDicom());
         
         return obs;
     }

}
