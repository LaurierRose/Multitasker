package com.example.multitasker.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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



        final ContextMenu addsoldier = new ContextMenu();
        final ContextMenu addgeneral = new ContextMenu();

        //Initialize root item
        TreeItem<String> rootItem = new TreeItem<>("Army");
        tvarmy.setRoot(rootItem);
        rootItem.setExpanded(true);
        tvarmy.setContextMenu(addgeneral);
        tvarmy.setEditable(true);

        MenuItem addMenuItem1 = new MenuItem("Add General");
        MenuItem addMenuItem2 = new MenuItem("Modify General");
        addgeneral.getItems().add(addMenuItem1);
        addgeneral.getItems().add(addMenuItem2);
        addMenuItem1.setOnAction((ActionEvent t) -> {
            TreeItem<String> newGeneral = new TreeItem<>("General");
            rootItem.getChildren().add(newGeneral);
        });
        addMenuItem2.setOnAction((ActionEvent t) -> {
            formPane.getChildren().add(generalForm);
        });






    }

}

