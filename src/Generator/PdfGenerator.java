package Generator;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.BaseFont;

import Models.PdfData;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator {

    public static void generatePDF(PdfData infoPdfData, String outputPath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputPath + File.separator + "pdf.pdf"));
            document.open();

            // Create a font
            BaseFont baseFont = BaseFont.createFont("path_to_your_font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 12);

            // Add the title
            Paragraph title = new Paragraph(infoPdfData.pdfName, font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            for (var infoImage : infoPdfData.imgs) {
                // Add title and description
                Paragraph imageInfo = new Paragraph("Titre: " + infoImage.titre, font);
                imageInfo.add(new Paragraph("Description: " + infoImage.description, font));
                document.add(imageInfo);

                // Add images
                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(infoImage.imgPath);
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
