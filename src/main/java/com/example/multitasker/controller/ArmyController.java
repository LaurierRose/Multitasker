package com.example.multitasker.controller;

import com.example.multitasker.module.army.GeneralItem;
import com.example.multitasker.module.army.SoldierItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
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
        TreeItem<String> rootItem = new TreeItem<>("Your Army");
        tvarmy.setRoot(rootItem);
        rootItem.setExpanded(true);
        tvarmy.setEditable(true);

        //Listen to event on treeview
        tvarmy.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);


    }

    private final ContextMenu addMenuG = new ContextMenu();
    private final ContextMenu addMenuS = new ContextMenu();
    MenuItem addMenuItemG = new MenuItem("Add General");
    MenuItem addMenuItemS = new MenuItem("Add Soldier");

    public void addMenu(TreeItem treeItem, MouseEvent event, MenuItem submenu, ContextMenu menu, char test, Button btnadd, VBox form, String type, TextField txtfield) {
        Node node = event.getPickResult().getIntersectedNode();
        menu.getItems().add(submenu);
        //Display menu position
        Bounds boundsInScreen = node.localToScreen(node.getBoundsInLocal());
        menu.show(node, boundsInScreen.getMaxX(), boundsInScreen.getMaxY());
        //Action of menu
        submenu.setOnAction((ActionEvent t) -> {
            if(formPane.getChildren().isEmpty()){
                formPane.getChildren().add(form);
            }
            btnadd.setOnMouseClicked(action -> {
                GeneralItem newGeneral = new GeneralItem(txtfield.getText());
                TreeItem newItem = new TreeItem<GeneralItem>(newGeneral);
                treeItem.getChildren().add(newItem);
                newItem.setValue(type+ " " + newGeneral.toString());
                formPane.getChildren().remove(form);
            });
        });

    }



    //Event listener on treeview
    EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
        handleMouseClicked(event);
    };
    //Actions when click detected
    private void handleMouseClicked(MouseEvent event) {
        TreeItem<String> currentNode = tvarmy.getSelectionModel().getSelectedItem();
        String itemValue = "";
        try {
            itemValue = currentNode.getValue();
        } catch (Exception e){
            System.err.println("Ho ho... ");
        }
        char test = itemValue.charAt(0);
        String name = (String) ((TreeItem<?>)tvarmy.getSelectionModel().getSelectedItem()).getValue();
        System.out.println("Item click: " + name);
        switch (test){
            case 'Y':
                addMenu(currentNode, event, addMenuItemG, addMenuG, test, btnaddg, generalForm, "General", txtgeneralName);
                currentNode.setExpanded(true);
                break;
            case 'G':
                addMenu(currentNode, event, addMenuItemS, addMenuS, test, btnadds, soldierForm, "Soldier", txtsoldierName);
                currentNode.setExpanded(true);
                break;
            case'S':
                break;
        }

    }


}

