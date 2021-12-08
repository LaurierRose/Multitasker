package com.example.multitasker.controller;

import com.example.multitasker.module.Library;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private MenuBar mbmenuBar;

    @FXML
    private MenuItem miquit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EventHandler<MouseEvent> displayForm = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!containerCentral.getChildren().isEmpty()) {
                    ObservableList child = containerCentral.getChildren();
                    containerCentral.getChildren().removeAll(child);
                }
            }
        };

        containerCentral.getChildren().removeAll(library);

        btnVoiture.setOnMouseClicked(e -> {
            displayForm.handle(e);
            containerCentral.getChildren().add(formvoiture);
        });

        btnVelo.setOnMouseClicked(e -> {
            displayForm.handle(e);
            containerCentral.getChildren().add(formvelo);
        });
    }


