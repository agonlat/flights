module com.example.fluganzeigetafel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    requires com.google.zxing;

    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;

    requires opencsv;
    requires org.apache.pdfbox;

    opens com.example.fluganzeigetafel.Flights.Utility to org.junit.jupiter.api;
    opens com.example.fluganzeigetafel.Contract to javafx.base;
    opens com.example.fluganzeigetafel to javafx.fxml;
    exports com.example.fluganzeigetafel;

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
}