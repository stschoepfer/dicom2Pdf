/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.dicom.dicomUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import st.schoepfer.dicom2pdf.dicom.entities.Observation;
import st.schoepfer.dicom2pdf.dicom.entities.Patient;
import st.schoepfer.dicom2pdf.dicom.handler.ImageHandler;
import st.schoepfer.dicom2pdf.dicom.handler.ObservationHandler;
import st.schoepfer.dicom2pdf.dicom.handler.PatientInfoHandler;
import st.schoepfer.dicom2pdf.pdf.handler.PdfFileHandler;

/**
 *
 * @author Stefan
 */
public class PDFFromDicomHandler {
    
    public enum LogoPosition {
        LEFT,
        CENTER,
        RIGHT
    }
    
    
    String dicomPath;
    String pdfPath;
    
    Patient patient;
    Observation observation;
    BufferedImage image;
    
    PdfFileHandler pdfHandler;
        
    private PDFFromDicomHandler(String dicomPath, String pdfPath) {
        this.dicomPath = dicomPath;
        this.pdfPath = pdfPath;
    }
    
    private void getDicomObjects() throws IOException {
        File aFile = new File(this.dicomPath);
        ObservationHandler oh = new ObservationHandler(aFile);
        this.observation = oh.getObservation();
        oh = null;
        
        PatientInfoHandler pih = new PatientInfoHandler(aFile);
        this.patient = pih.getPatient();
        pih = null;
        
        ImageHandler ih = new ImageHandler(aFile);
        this.image = ih.getBufferdImageFile();
        ih = null;
    }
    
    private void addHeaderToPdf() {
        
    }
    
    public void addLogo(BufferedImage image, LogoPosition position, int lenght, int height) {
        
    }
    
    private void createPDF() {
        this.pdfHandler = new PdfFileHandler(this.pdfPath);
    }
}
