package Generator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Models.PdfData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator {

    public static void generatePDF(PdfData infoPdfData, String outputPath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath + File.separator + "pdf.pdf"));
            document.open();

            // Create a font
            Font fontMainTitle = FontFactory.getFont(FontFactory.HELVETICA, 36, Font.BOLD);
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD);//new Font(baseFont, 12);
            Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
            
            // Add the title
            fontMainTitle.setColor(79, 129, 189);
            Paragraph title = new Paragraph(infoPdfData.pdfName, fontMainTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            for (var infoImage : infoPdfData.imgs) {
                // Add title and description
                Paragraph imageInfo = new Paragraph("\n\n\n\nTitre: " + infoImage.titre, fontTitle);
                imageInfo.add(new Paragraph("\n\nDescription:"));
                imageInfo.add(new Paragraph(  "            " + infoImage.description+"\n\n", fontParagraph));
                document.add(imageInfo);

                // Add images
                Image image = Image.getInstance(infoImage.imgPath);
                image.setAlignment(Element.ALIGN_CENTER);
                document.add(image);

                // Start a new page (optional)
                document.newPage();
            }

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
