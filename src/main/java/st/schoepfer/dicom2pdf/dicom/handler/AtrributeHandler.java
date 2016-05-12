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
import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;


/**
 *
 * @author Stefan
 */
public class AtrributeHandler {
    File theDicomFile;
    DicomInputStream dicomInputStream;
    
    boolean isReady = false;
    Attributes attri;
    
    public AtrributeHandler(File aDicomFile) {
        try {
            this.theDicomFile = aDicomFile;
            this.attri = this.getDicomAtributes();
            this.dicomInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(AtrributeHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Attributes getDicomAtributes() {
        try {
            dicomInputStream = new DicomInputStream(this.theDicomFile);
            return dicomInputStream.readDataset(-1, Tag.PixelData);
            
        }catch(Exception ex) {
            return null;
        }
    }
    
    public boolean isRedyToUse() {
        return this.isReady;
    }
    
    public String getElementAsString(int tagID) {
       return this.attri.getString(tagID);
    }
    
    public Date getElementAsDate(int tagID) {
       return this.attri.getDate(tagID);
    }
    
    
}
