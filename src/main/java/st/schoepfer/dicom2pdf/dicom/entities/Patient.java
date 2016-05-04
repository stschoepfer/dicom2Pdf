/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.entities;

import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Patient {
    String demiliter;
    String patientPrename;
    String patientName;
    Date patientBirthdate;
    String patientID;
    
    
    public Patient(String patientID) {
        this.patientID = patientID;
    }
    
    public String getPatientName() {return this.patientName;}
    public String getPatientPrename() {return this.patientPrename;}
    public String getPatientID() {return this.patientID;}
    public Date getPatientBirthdate() {return this.patientBirthdate;}
    public void setPatientNameDemilited(String name, String demil, int posOfLastname) {
        
        String newDemiliter = demil;
        if (newDemiliter.equals("^")) {
          newDemiliter = "\\^";
        }
        
        String[] names = name.split(newDemiliter);
        
       
        this.patientName = names[posOfLastname];
        
        int posOfPreName = -1;
        if (posOfLastname==0) {
            posOfPreName = 1;
        } else {
            posOfPreName = 0;
        }
        
        this.patientPrename = names[posOfPreName];
        
    }
    public void setPatientName(String name, String prename) {
        this.patientName = name;
        this.patientPrename = prename;
    }
    public void setBirthdate(Date birthday) {
        this.patientBirthdate = birthday;
    }
}
