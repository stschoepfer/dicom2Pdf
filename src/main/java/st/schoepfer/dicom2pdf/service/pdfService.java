/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import st.schoepfer.dicom2pdf.dicom.entities.Patient;
import st.schoepfer.dicom2pdf.dicom.handler.ImageHandler;
import st.schoepfer.dicom2pdf.dicom.handler.ObservationHandler;
import st.schoepfer.dicom2pdf.dicom.handler.PatientInfoHandler;
import st.schoepfer.dicom2pdf.pdf.handler.BarcodeHandler;
import st.schoepfer.dicom2pdf.pdf.handler.PDFFont;
import st.schoepfer.dicom2pdf.pdf.handler.PdfFileHandler;

/**
 *
 * @author Stefan
 */
public class pdfService {
    
    File aDicomFile;
    PdfFileHandler pdfHandler;
    
    public pdfService(String dicomFilePath, String pdfFilePath) throws FileNotFoundException{
        this.aDicomFile = new File(dicomFilePath);
        
        if (this.aDicomFile.exists() == false) {
            throw new FileNotFoundException();
        }
        
        this.pdfHandler = new PdfFileHandler(pdfFilePath);
        
        this.addPatientInformationsFromDicomToPDF();
        this.addObservationInformationFromDicomToPDF();
        
        try {
            this.addImage();
        } catch (IOException ex) {
            // Logger.getLogger(pdfService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    private void addPatientInformationsFromDicomToPDF() {
        PatientInfoHandler pih = new PatientInfoHandler(this.aDicomFile);
        Patient patient = pih.getPatient();
        
        BarcodeHandler barcode = new BarcodeHandler();
        BufferedImage code39PID = barcode.addBarcode(patient.getPatientID(), BarcodeHandler.BarcodeType.CODE39, 15, 50);
        // Top y = 750 . bottom = 0
        // Left x =
        
        
        PDFFont patFonts = new PDFFont(PDType1Font.HELVETICA, Color.BLACK, 10f);
        PDFFont patFontsBold = new PDFFont(PDType1Font.HELVETICA_BOLD, Color.BLACK, 10f);
        //PID
        pdfHandler.addTextAtPosition(patFonts, "PID: ", 15, 680);
        pdfHandler.addTextAtPosition(patFontsBold, patient.getPatientID(), 100, 680);
        pdfHandler.addBufferedImage(code39PID, 1, 150, 677);
        
        //Name
        pdfHandler.addTextAtPosition(patFonts, "Nachname:" , 15, 665);
        pdfHandler.addTextAtPosition(patFontsBold, patient.getPatientName(), 100, 665);
        
        //Vorname
        pdfHandler.addTextAtPosition(patFonts, "Vorname:" , 15, 650);
        pdfHandler.addTextAtPosition(patFontsBold, patient.getPatientPrename(), 100, 650);
        
    }
    
    private void addObservationInformationFromDicomToPDF() {
        ObservationHandler oh = new ObservationHandler(this.aDicomFile);
        
        PDFFont patFonts = new PDFFont(PDType1Font.HELVETICA, Color.BLACK, 10f);
        PDFFont patFontsBold = new PDFFont(PDType1Font.HELVETICA_BOLD, Color.BLACK, 10f);
        
        BarcodeHandler barcode = new BarcodeHandler();
        
        String FID = oh.getCaseIDFromDicom();
        BufferedImage code39PID = null;
        
        if (FID!=null && !FID.equals("n/a")) {
             code39PID = barcode.addBarcode(FID, BarcodeHandler.BarcodeType.CODE39, 15, 50);
             pdfHandler.addBufferedImage(code39PID, 1, 500, 677);
        } else {
            FID = "n/a";
        }
        
        //FID
        pdfHandler.addTextAtPosition(patFonts, "FID: ", 300, 680);
        pdfHandler.addTextAtPosition(patFontsBold, FID, 450, 680);
        
        //Klink
        pdfHandler.addTextAtPosition(patFonts, "Klinik: ", 300, 665);
        pdfHandler.addTextAtPosition(patFontsBold, oh.getClinicFromDicom(), 450, 665);
        
        //Modalität
        pdfHandler.addTextAtPosition(patFonts, "Modalität: ", 300, 650);
        pdfHandler.addTextAtPosition(patFontsBold, oh.getModalityFromDicom(), 450, 650);

        //Untersuchung
        pdfHandler.addTextAtPosition(patFonts, "StudyID: ", 300, 635);
        pdfHandler.addTextAtPosition(patFontsBold, oh.getStudyIDFromDicom(), 450, 635);

        //Untersuchung von
        pdfHandler.addTextAtPosition(patFonts, "Datum: ", 300, 620);
        pdfHandler.addTextAtPosition(patFontsBold, oh.getStudyDateFromDicom().toString() , 450, 620);

        //Arzt
        pdfHandler.addTextAtPosition(patFonts, "Arzt: ", 300, 605);
        pdfHandler.addTextAtPosition(patFontsBold, oh.getThreatingDoctorFromDicom(), 450, 605);
        
    }
    
    private void addImage() throws IOException {
        ImageHandler ih = new ImageHandler(this.aDicomFile);
        BufferedImage bi = ih.getBufferdImageFile();
        int width = bi.getWidth();
        int height = bi.getHeight();
        Image img = null;
        try {
            if (width > 560) {
            double fac = ((double)width / (double)560);
            Double dblW =((double)width / fac);
            Double dblH =((double)height / fac);
          
            if (bi instanceof BufferedImage) {
               img = bi.getScaledInstance(dblW.intValue(), dblH.intValue(), Image.SCALE_SMOOTH);
               bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
               
               Graphics2D bGr = bi.createGraphics();
               bGr.drawImage(img, 0, 0, null);
               bGr.dispose();
            }
            }
        }
        catch(Exception e) {
            System.out.println("SCHEISSE: " + e.getMessage());
        }
        
        pdfHandler.addBufferedImage(bi, 1, 20, 100);
    }
    
    
}
