/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.schoepfer.dicom2pdf.pdf.handler;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Stefan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({st.schoepfer.dicom2pdf.pdf.handler.PdfFileHandlerIT.class, st.schoepfer.dicom2pdf.pdf.handler.BarcodeHandlerIT.class})
public class HandlerITSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
