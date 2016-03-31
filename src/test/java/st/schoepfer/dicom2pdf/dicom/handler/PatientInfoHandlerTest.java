/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class PatientInfoHandlerTest {
    
    private final File dicomTestFile = new File("C:\\dicom\\test.dcm");

    
    public PatientInfoHandlerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetPatientIDFromDicom() {
        System.out.println("getPatientIDFromDicom");
        PatientInfoHandler instance = new PatientInfoHandler(dicomTestFile);;
        String expResult = "12345";
        String result = instance.getPatientIDFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPatientNameFromDicom() {
        System.out.println("getPatientNameFromDicom");
        PatientInfoHandler instance = new PatientInfoHandler(dicomTestFile);
        String expResult = "TEST^TEST12345";
        String result = instance.getPatientNameFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPatientBirthdateFromDicom() throws Exception {
        System.out.println("getPatientBirthdateFromDicom");
        PatientInfoHandler instance = new PatientInfoHandler(dicomTestFile);
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date expResult = sdf.parse("18111858");
        Date result = instance.getPatientBirthdateFromDicom();
        assertEquals(expResult, result);
    }

    
}
