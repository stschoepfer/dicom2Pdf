
import java.io.File;
import st.schoepfer.dicom2pdf.dicom.handler.ImageHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stefan
 */
public class AppTest {
    public static void main (String [] args) {
        
        File dicomTestFile = new File("C:\\dicom\\test.dcm");
        ImageHandler ih = new ImageHandler(dicomTestFile);
        
        try {
            ih.getBufferdImageFile();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
