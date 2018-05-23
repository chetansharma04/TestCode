package iText;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HTMLtoPDF {
    public static void main( String[] args ) throws DocumentException, IOException
	    { //chetan
	      // step 1
	        Document document = new Document();
	        // step 2
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/generatedPDF/generatedPDF.pdf"));
	        // step 3
	        document.open();
	        // step 4
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,new FileInputStream
//	        		("D:/Dashboard/GRC/Demo_POCs/Dominic_Compliance/TruOps_DFM_MoSCoW.htm")); 
	        		("http://10.20.10.130:9080/TruOps/cmp/adComparator.do?userAction=true&" +
	        				"method=compareADs&viewFor=compareAD&TOKEN=5HW0-O686-56YI-NYKO-9PU3-1EOI-Q2YI-RG8O"));
	        //step 5
	         document.close();
	        System.out.println( "PDF Created!" );
	    }

}
