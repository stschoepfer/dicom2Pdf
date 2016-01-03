/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import st.schoepfer.dicom2pdf.dicom.entities.Observation;

/**
 *
 * @author Stefan
 */
public class ObservationHandlerTest {
    
    private final File dicomTestFile = new File("E:\\test.dcm");  
    ObservationHandler instance;
    
    SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyy");
    SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
    
    
    public ObservationHandlerTest() {
         instance = new ObservationHandler(dicomTestFile);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetManufacturFromDicom() {
        System.out.println("getManufacturFromDicom");
        String expResult = "THOSHIBA_MEC_US";
        String result = instance.getManufacturFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetModalityFromDicom() {
        System.out.println("getModalityFromDicom");
        String expResult = "US";
        String result = instance.getModalityFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetThreatingDoctorFromDicom() {
        System.out.println("getThreatingDoctorFromDicom");
        String expResult = "Dr. Dombrowski";
        String result = instance.getThreatingDoctorFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetClinicFromDicom() {
        System.out.println("getClinicFromDicom");
        String expResult = "Fachaerztehaus Frick";
        String result = instance.getClinicFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStudyDateFromDicom() throws ParseException {
        System.out.println("getStudyDateFromDicom");
        Date expResult = sdfDate.parse("22062015");
        Date result = instance.getStudyDateFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStudyTimeFromDicom() throws ParseException {
        System.out.println("getStudyTimeFromDicom");
        Date expResult = sdfTime.parse("12:07:57");
        Date result = instance.getStudyTimeFromDicom();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStudyIDFromDicom() {
        System.out.println("getStudyIDFromDicom");
        String expResult = "20150622-1207";
        String result = instance.getStudyIDFromDicom();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetObservation() {
        System.out.println("getObservation");
        Observation expResult = null;
        Observation result = instance.getObservation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
