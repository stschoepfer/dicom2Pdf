/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.DicomObject;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che2.io.DicomInputStream;

/**
 *
 * @author Stefan
 */
public class AtrributeHandler {
    File theDicomFile;
    DicomInputStream dicomInputStream;
    DicomObject dmObject;
    boolean isReady = false;

    public AtrributeHandler(File aDicomFile) {
        this.theDicomFile = aDicomFile;
        
        try {
            dicomInputStream = new DicomInputStream(this.theDicomFile);
            dmObject = dicomInputStream.readDicomObject();
            dmObject.remove(Tag.PixelData);  
            this.isReady = true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            isReady = false;
        }
    }
    
    public boolean isRedyToUse() {
        return this.isReady;
    }
    
    public DicomElement affichageDicomItem(DicomObject object, int TAG) throws IOException
     {
         Iterator<DicomElement> iter = object.iterator();
         boolean hasFound = false;
         DicomElement returnEl = null; 
         while(iter.hasNext()) {
            DicomElement element = iter.next();
            // System.out.println(element.tag() + " --- CHECK: " + element.toString());
            int tag = element.tag(); 
             if(tag == TAG){
                 hasFound = true;
                 returnEl = element;
                 break;
             }
         }
         
         if (hasFound) {
             System.out.println(TAG + " gefunden");
         } else {
             System.out.println(TAG + "NICHT!!!!!!!!!! gefunden");
         }
         return returnEl;
     }
    
}
