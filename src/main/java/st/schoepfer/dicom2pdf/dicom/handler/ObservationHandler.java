/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;


import java.io.File;
// import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
// import java.util.logging.Level;
// import java.util.logging.Logger;
import org.dcm4che3.data.Tag;
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
         final int TAG = Tag.Manufacturer;      
         return super.getElementAsString(TAG);
     }

     public String getModalityFromDicom() {
         final int TAG = Tag.Modality;
         return super.getElementAsString(TAG);
     }     
     
     public String getThreatingDoctorFromDicom() {
         final int TAG = Tag.OperatorsName;
         return super.getElementAsString(TAG);
     }
     
     public String getClinicFromDicom() {
         final int TAG = Tag.InstitutionName;
         return super.getElementAsString(TAG);
     }
     
     public Date getStudyDateFromDicom() {
         final int TAG = Tag.StudyDate;
         return super.getElementAsDate(TAG);
     }
     
     public Date getStudyTimeFromDicom() {
         final int TAG = Tag.StudyTime;
         return super.getElementAsDate(TAG);
     }
     
     public String getStudyIDFromDicom() {
         final int TAG = Tag.StudyID;
         return super.getElementAsString(TAG);
     }
     
     public Date getObservationDate() {
         final int TAG = Tag.ObservationDateTime;
         return super.getElementAsDate(TAG);
     }
     
     public String getCaseIDFromDicom() {
         final int TAG = 3670032;
         String caseID = "";

         return super.getElementAsString(TAG);
         
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
         obs.setObservationDateTime(this.getObservationDate());
         return obs;
     }

}

