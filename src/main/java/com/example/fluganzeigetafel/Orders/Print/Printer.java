package com.example.fluganzeigetafel.Orders.Print;

import com.example.fluganzeigetafel.Orders.Data.CSVRow;
import com.example.fluganzeigetafel.Orders.Order;
import com.example.fluganzeigetafel.Suborders.Suborder;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * The Printer class provides methods for creating PDF documents for orders and suborders.
 */
public class Printer {
/**
     * Creates a PDF document for the given order.
     *
     * @param order The order to create the PDF for.
     */
    public void createPDF(Order order) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream stream = new PDPageContentStream(document, page);


            stream.setFont(PDType1Font.HELVETICA, 25);
            stream.beginText();
            stream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);

            stream.showText("Order " + order.getAUKEY());
            stream.endText();

            stream.moveTo(50, page.getMediaBox().getHeight() - 75);
            stream.setStrokingColor(Color.BLACK);
            stream.setLineWidth(1.0f);
            stream.lineTo(page.getMediaBox().getWidth() - 50, page.getMediaBox().getHeight() - 75);
            stream.stroke();

            stream.setFont(PDType1Font.HELVETICA, 12);
            float y = page.getMediaBox().getHeight() - 100;
            float x = 50;
            int i = 0;


           ArrayList<CSVRow> rs = order.getCSVRows();


            for (CSVRow row : rs) {


                    if (i == 40) {
                        x = 300;
                        y = page.getMediaBox().getHeight() - 100;
                    }
                    stream.beginText();

                    stream.newLineAtOffset(x, y);

                    stream.showText(row.getDesignation());
                    stream.endText();
                    stream.beginText();
                    stream.newLineAtOffset(x + 100, y);
                    stream.showText(row.getValue());
                    stream.endText();

                    y = y - 15;
                    i++;

            }

            stream.moveTo(50, 100);
            stream.setStrokingColor(Color.BLACK);
            stream.setLineWidth(1.0f);
            stream.lineTo(page.getMediaBox().getWidth() - 50, 100);
            stream.stroke();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            Date d = new Date();
            String formattedDate = dateFormat.format(d);

            stream.beginText();
            stream.newLineAtOffset(50, 75);
            stream.showText("Generated on: " + formattedDate);
            stream.endText();


            stream.close();
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "Orders"+order.getAUKEY()+".pdf";
            document.save(filePath);

            // Close the document
            document.close();

            // Open the created PDF file using the default PDF viewer
            Desktop.getDesktop().open(new File(filePath));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
 /**
     * Creates a PDF document for the given suborder.
     *
     * @param suborder The suborder to create the PDF for.
     */
    public void createPDF(Suborder suborder) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream stream = new PDPageContentStream(document, page);


            stream.setFont(PDType1Font.HELVETICA, 25);
            stream.beginText();
            stream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);

            stream.showText("Suborder " + suborder.getUAKEY());
            stream.endText();

            stream.moveTo(50, page.getMediaBox().getHeight() - 75);
            stream.setStrokingColor(Color.BLACK);
            stream.setLineWidth(1.0f);
            stream.lineTo(page.getMediaBox().getWidth() - 50, page.getMediaBox().getHeight() - 75);
            stream.stroke();

            stream.setFont(PDType1Font.HELVETICA, 12);
            float y = page.getMediaBox().getHeight() - 100;
            float x = 50;
            int i = 0;


            ArrayList<CSVRow> rs = suborder.getCSVRows();


            for (CSVRow row : rs) {


                if (i == 40) {
                    x = 300;
                    y = page.getMediaBox().getHeight() - 100;
                }
                stream.beginText();

                stream.newLineAtOffset(x, y);

                stream.showText(row.getDesignation());
                stream.endText();
                stream.beginText();
                stream.newLineAtOffset(x + 100, y);
                stream.showText(row.getValue());
                stream.endText();

                y = y - 15;
                i++;

            }

            stream.moveTo(50, 100);
            stream.setStrokingColor(Color.BLACK);
            stream.setLineWidth(1.0f);
            stream.lineTo(page.getMediaBox().getWidth() - 50, 100);
            stream.stroke();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            Date d = new Date();
            String formattedDate = dateFormat.format(d);

            stream.beginText();
            stream.newLineAtOffset(50, 75);
            stream.showText("Generated on: " + formattedDate);
            stream.endText();


            stream.close();
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "Suborder"+suborder.getUAKEY()+".pdf";
            document.save(filePath);

            // Close the document
            document.close();

            // Open the created PDF file using the default PDF viewer
            Desktop.getDesktop().open(new File(filePath));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

