package com.example.fluganzeigetafel.CustomDialogs;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Popup extends Stage {
    public Popup(String msg) {
        Label popupLabel = new Label(msg);
        StackPane popupLayout = new StackPane(popupLabel);
        this.setScene(new Scene(popupLayout, 250, 100));
        this.initStyle(StageStyle.UNDECORATED);

        Duration popupDuration = Duration.seconds(2);

        // Create a timeline to close the popup after the specified duration
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> this.show()),
                new KeyFrame(popupDuration, e -> this.hide())
        );

        // Show the timeline
        timeline.play();
    }
}
