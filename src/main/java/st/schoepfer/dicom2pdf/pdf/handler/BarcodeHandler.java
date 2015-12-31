/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;

/**
 *
 * @author Stefan
 */
public class BarcodeHandler {

    public enum BarcodeType {
	CODE39,
	CODE128,
        QRCODE;
    }
    
    public BufferedImage addBarcode(String aCode, BarcodeType barcodeType, int height, int width) {
	
        
        Writer writer = this.getBarcodeWriter(barcodeType);
	BarcodeFormat bf = this.getBarcodeFormat(barcodeType); 

                
         BufferedImage buffImage = null;
		
	try 
        {
	    BitMatrix theCode = writer.encode(aCode, bf, width, height);
            buffImage =  MatrixToImageWriter.toBufferedImage(theCode);
	
            return buffImage;
	
	} catch(Exception e) 
        {
	    return null;
	}
    }
    
    private Writer getBarcodeWriter(BarcodeType barcodeType) {
        Writer writer = null;

        if(barcodeType == BarcodeType.CODE39) {
            writer = new Code39Writer();
	} else if (barcodeType == BarcodeType.CODE128) {
            writer = new Code128Writer();
	} else if (barcodeType == BarcodeType.QRCODE) {
            writer = new QRCodeWriter();
	}
        
        return writer;
    }
    
    private BarcodeFormat getBarcodeFormat(BarcodeType barcodeType) {
        BarcodeFormat bf = null; 
        
        if(barcodeType == BarcodeType.CODE39) {
            bf = BarcodeFormat.CODE_39;
	} else if (barcodeType == BarcodeType.CODE128) {
            bf = BarcodeFormat.CODE_128;
	} else if (barcodeType == BarcodeType.QRCODE) {
            bf = BarcodeFormat.QR_CODE;
	}
        
        return bf;
    }
}
