/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class ImageHandlerTest {

    // Because the file could contain medical information there will be no relative object to test it.
    private final File dicomTestFile = new File("C:\\dicom\\test.dcm");
    
    public ImageHandlerTest() {

    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetBufferdImageFile() throws Exception {
        System.out.println("getBufferdImageFile");
        ImageHandler instance = new ImageHandler(dicomTestFile);
        BufferedImage result = instance.getBufferdImageFile();
        assertNotNull(result);
    }

    @Test
    public void testSaveImagesAsJPEG() {
        System.out.println("SaveImagesAsJPEG");
        String path = "C:\\dicom\\"; // testPath.getPath();
        String filePrefix = "testFile";
        ImageHandler instance = new ImageHandler(this.dicomTestFile);
        instance.SaveImagesAsJPEG(path, filePrefix);
        // TODO review the generated test code and remove the default call to fail.
        File f = new File("C:\\dicom\\" + filePrefix  + "_jpeg.jpg");
        assertTrue(f.exists());
    }
    
}
