package com.cgm;

import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.*;

/** Create pdf document from xhtml
 * input String xhtml
 * input String directory path where to save pdf
 * When finished, it will save the pdf document to a location of our choice.
 * */

public class XmlToPdf {
    /**
     * @param xhtml a string
     * @param outputPath directory path where will be created pdf
     */

    public static void xhtmlToPdf(String xhtml, String outputPath) {
        try {
            String out;

            if (outputPath.endsWith(".pdf")) {
                out = outputPath;
            } else if (outputPath.endsWith("/") || outputPath.endsWith("\\")) {
                out = outputPath + "ConvertedFile" + ".pdf";
            } else {
                out = outputPath + "/" + "ConvertedFile" + ".pdf";
            }

            File output = new File(out);
            ITextRenderer iTextRenderer = new ITextRenderer();
            iTextRenderer.setDocumentFromString(xhtml);
            iTextRenderer.layout();
            OutputStream os = new FileOutputStream(output);
            iTextRenderer.createPDF(os);
            os.close();
        } catch (Exception e) {
            System.out.println("Can't create pdf from xhtml: " + e.getMessage());
        }
    }
}
