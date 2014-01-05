package com.script.excobot.cooker.gui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created for Educational Purposes, do not use maliciously!
 * Created with IntelliJ IDEA.
 * User: DELTA
 */
public class Form extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
        Scene scene = new Scene(root,300,300);
        stage.setScene(scene);
        stage.setTitle("AIO Cooker");
        stage.show();
    }


}
