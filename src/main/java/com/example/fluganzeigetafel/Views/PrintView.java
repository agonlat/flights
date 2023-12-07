package com.example.fluganzeigetafel.Views;

import com.example.fluganzeigetafel.Data.DataInterface;
import com.example.fluganzeigetafel.Data.Flight;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PrintView {
    public void createPDF() {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);

            document.addPage(page);

            PDPageContentStream stream = new PDPageContentStream(document, page);
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            stream.setFont(font, 25);


            stream.beginText();
            stream.newLineAtOffset(50,page.getMediaBox().getHeight()-50);
            stream.showText("Flights");
            stream.endText();

            stream.moveTo(50,page.getMediaBox().getHeight()-75);
            stream.setStrokingColor(Color.BLACK);
            stream.setLineWidth(1.0f);
            stream.lineTo(page.getMediaBox().getWidth()-50, page.getMediaBox().getHeight() - 75);
            stream.stroke();

            stream.setNonStrokingColor(Color.LIGHT_GRAY);
            float rectX = page.getMediaBox().getWidth()-300;
            float rextY = page.getMediaBox().getHeight() -250;

            stream.addRect(rectX,rextY,250,150);
            stream.fill();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();

            PDType1Font rect = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            stream.setFont(rect, 12);

            stream.setNonStrokingColor(Color.BLACK);
            stream.beginText();
            stream.newLineAtOffset(rectX + 20, rextY + 120);
            stream.showText("Generated on: " + dateFormat.format(date));
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(rectX + 20, rextY + 100);
            int fl = DataInterface.getInstance().getFlights().size();
            stream.showText("Flights: " + fl);
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(rectX + 20, rextY + 80);
            int c = DataInterface.getInstance().getChangedFlightsCounter();
            stream.showText("Changed flights: " + c);
            stream.endText();


            BufferedImage bf = PrintView.createBarCode("Generated on: " + dateFormat.format(date) +"\n"+"Flights: "+fl+"\nChanged flights: " + c, 75,75);

            File file = new File("qrcode.png");
            ImageIO.write(bf, "png", file);

            stream.drawImage(PDImageXObject.createFromFileByExtension(file, document), page.getMediaBox().getWidth()-150,rextY+200);





















            stream.close();
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "SamplePDF.pdf";
            document.save(filePath);

            // Close the document
            document.close();

            System.out.println("PDF created successfully!");

            // Open the created PDF file using the default PDF viewer
            Desktop.getDesktop().open(new File(filePath));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedImage createBarCode(String text, int width, int height) {

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

            BufferedImage qrCodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // Fill the QR code image with white color
            Graphics2D graphics = (Graphics2D) qrCodeImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);

            // Paint the QR code into the image using black color
            graphics.setColor(Color.BLACK);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            return qrCodeImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
