package com.example.fluganzeigetafel.Contract.Print;

import com.example.fluganzeigetafel.Contract.CSVRow;
import com.example.fluganzeigetafel.Contract.Contract;
import com.example.fluganzeigetafel.Contract.Data.ContractTable;
import com.example.fluganzeigetafel.DataInterface;
import com.example.fluganzeigetafel.Flights.Data.Flight;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
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

public class Printer {

    public void createPDF(Contract contract) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream stream = new PDPageContentStream(document, page);
           // PDType1Font font = new PDType1Font();

            stream.setFont(PDType1Font.HELVETICA, 25);
            stream.beginText();
            stream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);
            Flight f= (Flight)DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();
            stream.showText("Contract " + f.getKnr());
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

            Tab tab = DataInterface.getInstance().getTabPaneView().getSelectionModel().getSelectedItem();
            ContractTable table = null;
            HBox selectedContent = (HBox) tab.getContent();
            for (Node node : selectedContent.getChildren()) {
                if (node instanceof ContractTable) {
                    table = (ContractTable) node;
                    break;
                }
            }


            ArrayList<CSVRow> rs = table.getCsvRows();


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
            String filePath = currentDir + File.separator + "Contracts"+f.getKnr()+".pdf";
            document.save(filePath);

            // Close the document
            document.close();

            // Open the created PDF file using the default PDF viewer
            Desktop.getDesktop().open(new File(filePath));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void createPDFMULT(ArrayList<Contract> contracts) {
        try {

            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);


            Flight f = (Flight) DataInterface.getFlightsTable().getSelectionModel().getSelectedItem();


            for (ArrayList<CSVRow> rows :  f.getCsvListOfList()) {
                document.addPage(page);
                for (CSVRow row : rows) {



                    PDPageContentStream stream = new PDPageContentStream(document, page);


              //      PDType1Font font = new PDType1Font(PDType1Font.HELVETICA);



                stream.setFont(PDType1Font.HELVETICA, 25);
                stream.beginText();
                stream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);
                stream.showText("Contract " + f.getKnr());
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

                for (CSVRow csrow : rows) {
                    if (i == 40) {
                        x = 300;
                        y = page.getMediaBox().getHeight() - 100;
                    }
                    stream.beginText();
                    stream.newLineAtOffset(x, y);
                    stream.showText(csrow.getDesignation());
                    stream.endText();
                    stream.beginText();
                    stream.newLineAtOffset(x + 100, y);
                    stream.showText(csrow.getValue());
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


                    page = new PDPage(PDRectangle.A4);

                }
            }

            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + File.separator + "Contracts"+f.getKnr()+".pdf";
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

