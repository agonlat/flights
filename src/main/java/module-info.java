module com.example.fluganzeigetafel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires asciitable;
    requires com.google.zxing;


    opens com.example.fluganzeigetafel to javafx.fxml;
    exports com.example.fluganzeigetafel;
    exports com.example.fluganzeigetafel.Menu;
    opens com.example.fluganzeigetafel.Menu to javafx.fxml;
    exports com.example.fluganzeigetafel.Views;
    opens com.example.fluganzeigetafel.Views to javafx.fxml;
    exports com.example.fluganzeigetafel.Utility;
    opens com.example.fluganzeigetafel.Utility to javafx.fxml;
    exports com.example.fluganzeigetafel.CustomDialogs;
    opens com.example.fluganzeigetafel.CustomDialogs to javafx.fxml;
    exports com.example.fluganzeigetafel.Data;
    opens com.example.fluganzeigetafel.Data to javafx.fxml;
    exports com.example.fluganzeigetafel.Handler;
    opens com.example.fluganzeigetafel.Handler to javafx.fxml;
}