package com.example.fluganzeigetafel.Views;

import com.example.fluganzeigetafel.Data.Flight;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.IOException;

public class PrintView {
    public void createPDF(Flight flight) {
        try {
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, page.getMediaBox().getHeight() - 50);
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            contentStream.setFont(font, 25);
            contentStream.showText("Munich Airport");

            contentStream.newLineAtOffset(50, page.getMediaBox().getHeight() - 200);
            contentStream.showText("Flight list");
            contentStream.newLine();

            contentStream.newLine();
            contentStream.showText("FNR            KNR            REG            TYP            HA0            LSK            STT" +
                    "            ITT            POS            TER            MAD            SAA");
            contentStream.newLine();

            contentStream.newLine();

            contentStream.showText(flight.getFnr() + "            " +
                    flight.getKnr() + "            " +
                    flight.getReg() + "            " +
                    flight.getTyp() + "            " +
                    flight.getHa0() + "            " +
                    flight.getLsk() + "            " +
                    flight.getStt() + "            " +
                    flight.getItt() + "            " +
                    flight.getPos() + "            " +
                    flight.getTer() + "            " +
                    flight.getMad() + "            " +
                    flight.getSaa());

            contentStream.endText();  // End the first text block

            // Add more text or content here if needed

            contentStream.close();
            String path = System.getProperty("user.dir") + File.separator + "Flights.pdf"; // Combine directory and filename
            File file = new File(path);
            doc.save(file);
            java.awt.Desktop.getDesktop().open(file);

            doc.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
