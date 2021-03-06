package com.example.multitasker.controller;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;



public class MainController implements Initializable {

    @FXML
    private Button btnIMC;

    @FXML
    private Button btnarmy;

    @FXML
    private Button btnconverter;

    @FXML
    private Button btnlibrary;

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private VBox library;

    @FXML
    private Pane army;

    @FXML
    private VBox VboxIMC;

    @FXML

    private MenuItem menuQuit;

    @FXML
    private AnchorPane numericConverter;

    @FXML
    private MenuItem menuClose;

    @FXML
    private GridPane gridmenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EventHandler<MouseEvent> displayForm = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mainWindow.getChildren().isEmpty()) {
                    ObservableList child = mainWindow.getChildren();
                    mainWindow.getChildren().removeAll(child);
                }
            }
        };



        //Menu actions

        menuQuit.setOnAction(e->{
            System.exit(0);
        });

        menuClose.setOnAction(action->{
            ObservableList child = mainWindow.getChildren();
            mainWindow.getChildren().removeAll(child);
            mainWindow.getChildren().add(gridmenu);
        });


        //First visit
        mainWindow.getChildren().removeAll(library, army, VboxIMC, numericConverter);


        //Go to library application
        btnlibrary.setOnMouseClicked(e -> {
            displayForm.handle(e);
            mainWindow.getChildren().add(library);
        });

        //Go to army application
        btnarmy.setOnMouseClicked(e -> {
            displayForm.handle(e);
            mainWindow.getChildren().add(army);
        });

        btnIMC.setOnMouseClicked(e -> {
            displayForm.handle(e);
            mainWindow.getChildren().add(VboxIMC);
        });
        btnconverter.setOnMouseClicked(e -> {
            displayForm.handle(e);
            mainWindow.getChildren().add(numericConverter);
        });

    }
}


