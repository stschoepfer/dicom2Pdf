/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.xml.internal.fastinfoset.sax.AttributesHolder;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageReader;
import org.dcm4che2.data.DicomElement;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.SpecificCharacterSet;
import org.dcm4che2.data.Tag;
import static org.dcm4che2.data.Tag.Time;
import org.dcm4che2.io.DicomInputStream;

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

}
