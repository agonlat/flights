module com.example.fluganzeigetafel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    requires com.google.zxing;
    requires pdfbox.app;

    opens com.example.fluganzeigetafel.Contract to javafx.base;
    opens com.example.fluganzeigetafel to javafx.fxml;
    exports com.example.fluganzeigetafel;
    exports com.example.fluganzeigetafel.Controller;
    opens com.example.fluganzeigetafel.Controller to javafx.fxml;
    exports com.example.fluganzeigetafel.Manager;
    opens com.example.fluganzeigetafel.Manager to javafx.fxml;
    exports com.example.fluganzeigetafel.Utility;
    opens com.example.fluganzeigetafel.Utility to javafx.fxml;
    exports com.example.fluganzeigetafel.CustomDialogs;
    opens com.example.fluganzeigetafel.CustomDialogs to javafx.fxml;
    exports com.example.fluganzeigetafel.Data;
    opens com.example.fluganzeigetafel.Data to javafx.fxml;
    exports com.example.fluganzeigetafel.Handler;
    opens com.example.fluganzeigetafel.Handler to javafx.fxml;
}