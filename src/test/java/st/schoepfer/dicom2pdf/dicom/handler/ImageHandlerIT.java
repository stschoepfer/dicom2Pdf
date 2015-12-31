/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class ImageHandlerIT {
    
    public ImageHandlerIT() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBufferdImageFile method, of class ImageHandler.
     */
    @org.junit.Test
    public void testGetBufferdImageFile() throws Exception {
        System.out.println("getBufferdImageFile");
        ImageHandler instance = null;
        BufferedImage expResult = null;
        BufferedImage result = instance.getBufferdImageFile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SaveImagesAsJPEG method, of class ImageHandler.
     */
    @org.junit.Test
    public void testSaveImagesAsJPEG() {
        System.out.println("SaveImagesAsJPEG");
        String path = "";
        String filePrefix = "";
        ImageHandler instance = null;
        instance.SaveImagesAsJPEG(path, filePrefix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
