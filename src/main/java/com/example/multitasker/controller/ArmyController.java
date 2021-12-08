package com.example.multitasker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmyController implements Initializable {

    @FXML
    private Button btncreate;

    @FXML
    private TreeView<String> tvarmy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btncreate.setOnMouseClicked(action->{
            //Create root item
            String armyName = "Army";
            TreeItem<String> rootItem = new TreeItem<>(armyName);
            tvarmy.setRoot(rootItem);
        });


    }


}
