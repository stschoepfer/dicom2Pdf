/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;

import st.schoepfer.dicom2pdf.pdf.handler.BarcodeHandler;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class BarcodeHandlerIT {
    
    public BarcodeHandlerIT() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addBarcode method, of class BarcodeHandler.
     */
    @Test
    public void testAddBarcode() {
        System.out.println("addBarcode");
        String aCode = "";
        BarcodeHandler.BarcodeType barcodeType = null;
        int height = 0;
        int width = 0;
        BarcodeHandler instance = new BarcodeHandler();
        BufferedImage expResult = null;
        BufferedImage result = instance.addBarcode(aCode, barcodeType, height, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
