/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;

import st.schoepfer.dicom2pdf.pdf.handler.PdfFileHandler;
import java.awt.image.BufferedImage;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class PdfFileHandlerIT {
    
    public PdfFileHandlerIT() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFileName method, of class PdfFileHandler.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        PdfFileHandler instance = null;
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTextAtPosition method, of class PdfFileHandler.
     */
    @Test
    public void testAddTextAtPosition() {
        System.out.println("addTextAtPosition");
        String newText = "";
        int x = 0;
        int y = 0;
        PdfFileHandler instance = null;
        instance.addTextAtPosition(newText, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CountPages method, of class PdfFileHandler.
     */
    @Test
    public void testCountPages() {
        System.out.println("CountPages");
        PdfFileHandler instance = null;
        int expResult = 0;
        int result = instance.CountPages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SizeHeight method, of class PdfFileHandler.
     */
    @Test
    public void testSizeHeight() {
        System.out.println("SizeHeight");
        PdfFileHandler instance = null;
        float expResult = 0.0F;
        float result = instance.SizeHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SizeWidth method, of class PdfFileHandler.
     */
    @Test
    public void testSizeWidth() {
        System.out.println("SizeWidth");
        PdfFileHandler instance = null;
        float expResult = 0.0F;
        float result = instance.SizeWidth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPageByNumber method, of class PdfFileHandler.
     */
    @Test
    public void testGetPageByNumber() {
        System.out.println("getPageByNumber");
        int pageNumber = 0;
        PdfFileHandler instance = null;
        PDPage expResult = null;
        PDPage result = instance.getPageByNumber(pageNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBufferedImage method, of class PdfFileHandler.
     */
    @Test
    public void testAddBufferedImage() {
        System.out.println("addBufferedImage");
        BufferedImage buffImg = null;
        int page = 0;
        int x = 0;
        int y = 0;
        PdfFileHandler instance = null;
        instance.addBufferedImage(buffImg, page, x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
