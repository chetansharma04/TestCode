package iText;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TableExample_2 {
    public static void main(String[] args) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("d:/generatedPDF/HelloWorld-Table.pdf"));

            document.open();

            PdfPTable table = new PdfPTable(3); // 3 columns.
            float[] columnWidths = {2f, 1f, 1f};

            table.setWidths(columnWidths);
            PdfPCell cell1 = new PdfPCell(new Paragraph("32 Authority Documents Selected (View Selected)\n(Source ICF)"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));

            cell1.setBackgroundColor(WebColors.getRGBColor("#666"));
            
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            document.add(table);
            //para
            
            Paragraph paragraph1 = new Paragraph();
            
            Paragraph paragraph2 = new Paragraph();

            paragraph2.setSpacingAfter(25);
            paragraph2.setSpacingBefore(25);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setIndentationLeft(50);
            paragraph2.setIndentationRight(50);
        

        for(int i=0; i<10; i++){
            Chunk chunk = new Chunk(
                "This is a sentence which is long " + i + ". ");
            paragraph1.add(chunk);
            paragraph2.add(chunk);
        }

        document.add(paragraph1);
        document.add(paragraph2);
        
        
        //font
        
        Font font1 = new Font(Font.FontFamily.HELVETICA  , 25, Font.BOLD);
        Font font2 = new Font(Font.FontFamily.COURIER    , 18,
        Font.ITALIC | Font.UNDERLINE);
        Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 27);
    
    

    document.add(new Chunk(    "This is sentence 1. ", font1));
    document.add(new Phrase(   "This is sentence 2. ", font2));
    document.add(new Paragraph("This is sentence 3. ", font3));

            
            

            document.close();
            
            System.out.println( "PDF Created!" );
        } catch(Exception e){

        }
    }
}