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
import javafx.scene.text.Text;


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

    //Create Treeview Contextmenu
    static private final ContextMenu addMenuG = new ContextMenu();
    static private final ContextMenu addMenuS = new ContextMenu();
    static MenuItem addMenuItemG = new MenuItem("Add General");
    static MenuItem addMenuItemS = new MenuItem("Add Soldier");


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //first visit
        formPane.getChildren().removeAll(soldierForm, generalForm);

        //Initialize root item
        TreeItem<String> rootItem = new TreeItem<>("Your Army");
        tvarmy.setRoot(rootItem);
        rootItem.setExpanded(true);
        tvarmy.setEditable(true);

        //Initialize Context menus
        addMenuG.getItems().add(addMenuItemG);
        addMenuS.getItems().add(addMenuItemS);

        //Listen to event on treeview
        tvarmy.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);

    }



    public void addMenu(TreeItem treeItem, MouseEvent event, MenuItem submenu,
                        ContextMenu menu, char test, Button btnadd, VBox form,
                        String type, TextField txtfield, Node node) {
        //Display menu position
        Bounds boundsInScreen = node.localToScreen(node.getBoundsInLocal());
        menu.show(node, boundsInScreen.getMaxX(), boundsInScreen.getMaxY());
        //Action of Context menu
        submenu.setOnAction((ActionEvent t) -> {
            if(formPane.getChildren() != form){
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
        // To know where the user clicks
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)){
            TreeItem<String> currentNode = new TreeItem<>();
            currentNode = tvarmy.getSelectionModel().getSelectedItem();
            //Test on what is selected
            String itemValue = currentNode.getValue();
            char test = itemValue.charAt(0);
            String name = (String) ((TreeItem<?>)tvarmy.getSelectionModel().getSelectedItem()).getValue();
            System.out.println("Item click: " + name);
            switch (test){
                case 'Y':
                    addMenu(currentNode, event, addMenuItemG, addMenuG, test, btnaddg, generalForm, "General", txtgeneralName, node);
                    currentNode.setExpanded(true);
                    break;
                case 'G':
                    addMenu(currentNode, event, addMenuItemS, addMenuS, test, btnadds, soldierForm, "Soldier", txtsoldierName, node);
                    currentNode.setExpanded(true);
                    break;
                case'S':
                    break;


            }

        }

    }


}

