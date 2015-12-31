/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Observation {
    
    private final SimpleDateFormat datePrintFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    Date observationDate;
    String caseID;
    String threatingDoctor;
    String observetionDescripton;
    String observationID;
    String modality;
    String manufactur;
    
    public Observation(String obserID, Date obserDate) {
        this.observationDate = obserDate;
        this.observationID = obserID;
    }

    
    public Observation(String obserID, Date obserDate, String caseID) {
        this.observationDate = obserDate;
        this.observationID = obserID;
        this.caseID = caseID;
    }
    
    
    public Date getObservationDate() {
        return this.observationDate;
    }
    
    public String getObservationDateAsString() {
        return this.datePrintFormat.format(this.observationDate);
    }
    
    public String getCaseID() {
        return this.caseID;
    }
    
    public String getThreatingDoctor() {
        return this.threatingDoctor;
    }
    
    public String getDescription() {
        return this.observetionDescripton;
    }
}
