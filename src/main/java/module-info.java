module com.example.fluganzeigetafel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.zxing;

    requires junit; // Replace org.junit.jupiter.api and org.junit.platform.commons with junit

    requires opencsv;
    requires org.apache.pdfbox;

    opens com.example.fluganzeigetafel.Flights.Utility to junit; // Replace org.junit.jupiter.api with junit
    opens com.example.fluganzeigetafel.Orders to javafx.base;
    opens com.example.fluganzeigetafel to javafx.fxml;
    exports com.example.fluganzeigetafel;

    exports com.example.fluganzeigetafel.Tests;
    exports com.example.fluganzeigetafel.Flights.Controller;
    opens com.example.fluganzeigetafel.Flights.Controller to javafx.fxml;
    exports com.example.fluganzeigetafel.Flights.Manager;
    opens com.example.fluganzeigetafel.Flights.Manager to javafx.fxml;
    exports com.example.fluganzeigetafel.Flights.Utility;

    exports com.example.fluganzeigetafel.CustomDialogs;
    opens com.example.fluganzeigetafel.CustomDialogs to javafx.fxml;
    exports com.example.fluganzeigetafel.Flights.Data;
    opens com.example.fluganzeigetafel.Flights.Data to javafx.fxml;
    exports com.example.fluganzeigetafel.Flights.Handler;
    opens com.example.fluganzeigetafel.Flights.Handler to javafx.fxml;
    opens com.example.fluganzeigetafel.Orders.Statistics to javafx.base;
    opens com.example.fluganzeigetafel.Orders.Forms to javafx.base;
    opens com.example.fluganzeigetafel.Orders.Utilis to javafx.base;
    opens com.example.fluganzeigetafel.Suborders.Statistics to javafx.base;
    opens com.example.fluganzeigetafel.Orders.Data to javafx.base;


}
