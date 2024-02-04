package com.example.fluganzeigetafel.CustomDialogs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


/**
 * This custom popup is needed for the thread which load the flights, the Orders and Suborders.
 * @author latifiagon
 */
public class PopupSuccess extends Stage {
    /**
     * This constructor creates the popup with a time duration of 5 seconds. The content will be displayed on the main stage.
     * @param msg The text to be displayed
     * @param stage The stage where the popup should be displayed
     */
    public PopupSuccess(String msg, Stage stage) {
        Label popupLabel = new Label(msg);
        StackPane popupLayout = new StackPane(popupLabel);
        this.setScene(new Scene(popupLayout, 300,50));
        this.setX(stage.getWidth()-400);
        this.setY(stage.getHeight()-100);
        this.initStyle(StageStyle.UNDECORATED);

        Duration popupDuration = Duration.seconds(5);

        // Create a timeline to close the popup after the specified duration
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> this.show()),
                new KeyFrame(popupDuration, e -> this.hide())
        );

        // Show the timeline
        timeline.play();
    }
}
