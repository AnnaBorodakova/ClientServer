package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClient extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/connectionForm.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlFile));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}

