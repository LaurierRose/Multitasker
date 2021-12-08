package com.example.multitasker.controller;

import com.example.multitasker.module.army.GeneralItem;
import com.example.multitasker.module.army.TextFieldTreeCellImpl;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;


public class ArmyController implements Initializable {

    @FXML
    private MenuItem Corporal;

    @FXML
    private MenuItem Private;

    @FXML
    private MenuItem Seargeant;

    @FXML
    private Button btnaddg;

    @FXML
    private Button btnadds;

    @FXML
    private VBox soldierForm;

    @FXML
    private VBox generalForm;

    @FXML
    private SplitMenuButton sprank;

    @FXML
    private TreeView<String> tvarmy;

    @FXML
    private TextField txtgeneralName;

    @FXML
    private TextField txtsoldierName;

    @FXML
    private TextField txtvitalPoint;

    @FXML
    private VBox formPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EventHandler<MouseEvent> displayForm = new EventHandler<>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!formPane.getChildren().isEmpty()) {
                    ObservableList child = formPane.getChildren();
                    formPane.getChildren().removeAll(child);
                }
            }
        };
/*
//Pour afficher les formulaires d'édition des treeView items
        itemselected.setOnMouseClicked(e -> {
            displayForm.handle(e);
            formPane.getChildren().add(library);
        });
 */
        //first visit
        formPane.getChildren().removeAll(soldierForm, generalForm);


        //Initialize root item
        TreeItem<String> rootItem = new TreeItem<>("Army");
        tvarmy.setRoot(rootItem);
        rootItem.setExpanded(true);
        tvarmy.setEditable(true);
        tvarmy.setCellFactory((TreeView<String> p) ->
                new TextFieldTreeCellImpl());

        GeneralItem newItem = new GeneralItem("De Gaulle");
        rootItem.getChildren().add(newItem);



    }

}

