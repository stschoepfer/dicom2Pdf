/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;

import java.awt.Color;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Stefan
 */
public class PDFFont {
    PDFont font = PDType1Font.HELVETICA_BOLD;
    Color foreground = Color.black;
    float size;
    
    public PDFFont(PDType1Font font, Color color, float size) {
        this.font = font;
        this.foreground = color;
        this.size = size;
    }
    
    public float getSize() { return this.size;}
    public PDFont getFont() { return this.font;}
    public Color getColor() { return this.foreground;}
}
