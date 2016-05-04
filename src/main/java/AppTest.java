
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import st.schoepfer.dicom2pdf.dicom.handler.ImageHandler;
import st.schoepfer.dicom2pdf.pdf.handler.PdfFileHandler;
import st.schoepfer.dicom2pdf.service.pdfService;

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
        
        PdfFileHandler pdf = new PdfFileHandler("C:\\dicom\\apdf.pdf");
        
        try {
            pdfService service = new pdfService("C:\\dicom\\test.dcm", "C:\\dicom\\output.pdf");
        } catch (FileNotFoundException ex) {
            System.out.println("Schnauz-Mist: " + ex.getMessage());
        }
    }
}
