package Generator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import Models.PdfData;

import java.io.File;
import java.io.IOException;

public class PdfGenerator {

    public static void generatePDF(PdfData infoPdfData, String outputPath) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            //FontName font_name_3v= Standard14Fonts.getMappedFontName("HELVETICA_BOLD");
            PDFont pdfFont=  new PDType1Font(FontName.HELVETICA_BOLD);
            contentStream.beginText();
            contentStream.setFont(pdfFont, 12);
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText(infoPdfData.pdfName);

            for (var infoImage : infoPdfData.imgs) {
                // Add titre and description text
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("titre: " + infoImage.titre);
                contentStream.showText("\nDescription: " + infoImage.description);
                contentStream.endText();

                // Add images
                PDImageXObject image = PDImageXObject.createFromFile(infoImage.imgPath, document);
                contentStream.drawImage(image, 50, 500, image.getWidth(), image.getHeight());

                // Add a new page for the next set of info (optional)
                contentStream.close();
                page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                contentStream = new PDPageContentStream(document, page);
            }

            contentStream.close();
            document.save(outputPath+ File.separator+ "pdf.pdf");
            System.out.println(outputPath+ File.separator+ "pdf.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}