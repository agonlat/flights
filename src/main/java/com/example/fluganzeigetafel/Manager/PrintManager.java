package com.example.fluganzeigetafel.Manager;

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
import com.google.zxing.common.BitMatrix;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.fluganzeigetafel.Utility.UtilityMethods.leaveOneWhiteSpace;


public class PrintManager {
    public void createPDF(ArrayList<Flight> flights) {
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
            int fl = 0;

            if (DataInterface.getInstance().getTemporaryFlights()!=null) {
            fl = DataInterface.getInstance().getTemporaryFlights().size();
            } else
                fl = DataInterface.getInstance().getFlights().size();

            stream.showText("Flights: " + fl);
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(rectX + 20, rextY + 80);
            int c = DataInterface.getInstance().getChangedFlightsCounter();
            stream.showText("Changed flights: " + c);
            stream.endText();


            BufferedImage bf = PrintManager.createBarCode("Generated on: " + dateFormat.format(date) +"\n"+"Flights: "+fl+"\nChanged flights: " + c, 150,150);

            File file = new File("qrcode.png");
            ImageIO.write(bf, "png", file);

            stream.drawImage(PDImageXObject.createFromFileByExtension(file, document), 50,rextY);



            stream.beginText();
            float y = 500;
            stream.newLineAtOffset(30,y);
            stream.showText("|FNR");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(80, y);
            stream.showText("|" + "KNR");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(123.75f, y);
            stream.showText("|" + "REG");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(167.5f, y);
            stream.showText("|" + "TYP");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(205, y);
            stream.showText("|" + "HA0");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(236.25f, y);
            stream.showText("|" + "L");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(248.75f, y);
            stream.showText("|" + "STT");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(366.25f, y);
            stream.showText("|" + "ITT");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(480.75f, y);
            stream.showText("|" + "POS");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(514.25f, y);
            stream.showText("|" + "T");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(526.75f, y);
            stream.showText("|" + "MD");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(551.75f, y);
            stream.showText("|" + "SA");
            stream.endText();





            stream.beginText();
            stream.newLineAtOffset(30,y = y-5);
            stream.showText("_________________________________________________________________________________");
            stream.endText();



            boolean countFor60 = false;
            int cd = 0;



            for (int i = 0; i < flights.size(); i++) {

                 Flight f = flights.get(i);
                if (i == 20 || cd == 37) {
                    cd = 0;
                        stream.close();
                        PDPage pg = new PDPage(PDRectangle.A4);
                    document.addPage(pg);
                    stream = new PDPageContentStream(document, pg, PDPageContentStream.AppendMode.APPEND, true);
                        PDType1Font ft = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
                        stream.setFont(ft, 12);
                    countFor60 = true;
                    y = pg.getMediaBox().getHeight()-50;

                }

                stream.beginText();
                stream.newLineAtOffset(30,y=y-15);

                String fnr = leaveOneWhiteSpace(f.getFnr().trim());
                String knr = leaveOneWhiteSpace(f.getKnr().trim());
                String reg = leaveOneWhiteSpace(f.getReg().trim());
                String typ = leaveOneWhiteSpace(f.getTyp().trim());
                String ha0 = leaveOneWhiteSpace(f.getHa0().trim());
                String lsk = leaveOneWhiteSpace(f.getLsk().trim());
                String stt = leaveOneWhiteSpace(f.getStt().trim());
                String itt = leaveOneWhiteSpace(f.getItt().trim());
                String pos = leaveOneWhiteSpace(f.getPos().trim());
                String ter = leaveOneWhiteSpace(f.getTer().trim());
                String mad = leaveOneWhiteSpace(f.getMad().trim());
                String saa = leaveOneWhiteSpace(f.getSaa().trim());

                stream.showText("|"+fnr);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(80,y);
                stream.showText("|"+knr);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(123.75f,y);
                stream.showText("|"+reg);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(167.5f,y);
                stream.showText("|"+typ);
                stream.endText();





                stream.beginText();
                stream.newLineAtOffset(205,y);
                stream.showText("|"+ha0);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(236.25f,y);
                stream.showText("|"+lsk);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(248.75f,y);
                stream.showText("|"+stt);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(366.25f,y);
                stream.showText("|"+itt);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(480.75f,y);
                stream.showText("|"+pos);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(514.25f,y);
                stream.showText("|"+ter);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(526.75f,y);
                stream.showText("|"+mad);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(551.75f,y);
                stream.showText("|"+saa);
                stream.endText();




                stream.beginText();
                stream.newLineAtOffset(30,y=y-5);
                stream.showText("_________________________________________________________________________________");
                stream.endText();



            if (countFor60)
                cd++;

            }


            stream.close();
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "Flights.pdf";
            document.save(filePath);

            // Close the document
            document.close();

            // Open the created PDF file using the default PDF viewer
            Desktop.getDesktop().open(new File(filePath));



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void createPDF(Flight f) {
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


            BufferedImage bf = PrintManager.createBarCode("Generated on: " + dateFormat.format(date) +"\n"+"Flights: "+fl+"\nChanged flights: " + c, 150,150);

            File file = new File("qrcode.png");
            ImageIO.write(bf, "png", file);

            stream.drawImage(PDImageXObject.createFromFileByExtension(file, document), 50,rextY);


            ArrayList<Flight> flights = (ArrayList<Flight>) DataInterface.getInstance().getFlights();
            stream.beginText();
            float y = 500;
            stream.newLineAtOffset(30,y);
            stream.showText("|FNR");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(80, y);
            stream.showText("|" + "KNR");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(123.75f, y);
            stream.showText("|" + "REG");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(167.5f, y);
            stream.showText("|" + "TYP");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(205, y);
            stream.showText("|" + "HA0");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(236.25f, y);
            stream.showText("|" + "L");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(248.75f, y);
            stream.showText("|" + "STT");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(366.25f, y);
            stream.showText("|" + "ITT");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(480.75f, y);
            stream.showText("|" + "POS");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(514.25f, y);
            stream.showText("|" + "T");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(526.75f, y);
            stream.showText("|" + "MD");
            stream.endText();

            stream.beginText();
            stream.newLineAtOffset(551.75f, y);
            stream.showText("|" + "SA");
            stream.endText();





            stream.beginText();
            stream.newLineAtOffset(30,y = y-5);
            stream.showText("_________________________________________________________________________________");
            stream.endText();






                stream.beginText();
                stream.newLineAtOffset(30,y=y-15);

                String fnr = leaveOneWhiteSpace(f.getFnr().trim());
                String knr = leaveOneWhiteSpace(f.getKnr().trim());
                String reg = leaveOneWhiteSpace(f.getReg().trim());
                String typ = leaveOneWhiteSpace(f.getTyp().trim());
                String ha0 = leaveOneWhiteSpace(f.getHa0().trim());
                String lsk = leaveOneWhiteSpace(f.getLsk().trim());
                String stt = leaveOneWhiteSpace(f.getStt().trim());
                String itt = leaveOneWhiteSpace(f.getItt().trim());
                String pos = leaveOneWhiteSpace(f.getPos().trim());
                String ter = leaveOneWhiteSpace(f.getTer().trim());
                String mad = leaveOneWhiteSpace(f.getMad().trim());
                String saa = leaveOneWhiteSpace(f.getSaa().trim());

                stream.showText("|"+fnr);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(80,y);
                stream.showText("|"+knr);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(123.75f,y);
                stream.showText("|"+reg);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(167.5f,y);
                stream.showText("|"+typ);
                stream.endText();





                stream.beginText();
                stream.newLineAtOffset(205,y);
                stream.showText("|"+ha0);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(236.25f,y);
                stream.showText("|"+lsk);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(248.75f,y);
                stream.showText("|"+stt);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(366.25f,y);
                stream.showText("|"+itt);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(480.75f,y);
                stream.showText("|"+pos);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(514.25f,y);
                stream.showText("|"+ter);
                stream.endText();

                stream.beginText();
                stream.newLineAtOffset(526.75f,y);
                stream.showText("|"+mad);
                stream.endText();


                stream.beginText();
                stream.newLineAtOffset(551.75f,y);
                stream.showText("|"+saa);
                stream.endText();




                stream.beginText();
                stream.newLineAtOffset(30,y=y-5);
                stream.showText("_________________________________________________________________________________");
                stream.endText();







        stream.close();
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "Flights.pdf";
            document.save(filePath);

            // Close the document
            document.close();



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
