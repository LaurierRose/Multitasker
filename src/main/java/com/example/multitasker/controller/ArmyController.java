package com.example.multitasker.controller;

import com.example.multitasker.module.army.GeneralItem;
import com.example.multitasker.module.army.SoldierItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    @FXML
    private Label lblnbGeneral;

    @FXML
    private Label lblnbSoldier;

    @FXML
    private Label lnlUnderCommandS;


    //Create Treeview Contextmenu
    static private final ContextMenu addMenuG = new ContextMenu();
    static private final ContextMenu addMenuS = new ContextMenu();
    static MenuItem addMenuItemG = new MenuItem("Add General");
    static MenuItem addMenuItemS = new MenuItem("Add Soldier");

    //Troops overview
    public static int nbSoldier = 0;
    public static int nbGeneral = 0;
    private final List<GeneralItem> generalList = new ArrayList<>();
    private final List<SoldierItem> soldierList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //first visit
        formPane.getChildren().removeAll(soldierForm, generalForm);
        lblnbGeneral.setText(String.valueOf(nbGeneral));
        lblnbSoldier.setText(String.valueOf(nbSoldier));


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


    public void addMenu(TreeItem treeItem, MenuItem submenu,
                        ContextMenu menu, char test, VBox form, Node node) {
        //Display menu position
        Bounds boundsInScreen = node.localToScreen(node.getBoundsInLocal());
        menu.show(node, boundsInScreen.getMaxX(), boundsInScreen.getMaxY());
        //Action of Context menu
        submenu.setOnAction((ActionEvent t) -> {
            if(formPane.getChildren() != form){
                formPane.getChildren().add(form);
            }
            if(test == 'Y'){
                btnaddg.setOnMouseClicked(action -> {
                    GeneralItem newGeneral = new GeneralItem(txtgeneralName.getText());
                    TreeItem newItem = new TreeItem<>(newGeneral);
                    treeItem.getChildren().add(newItem);
                    newItem.setValue(newGeneral.toString());
                    formPane.getChildren().remove(form);
                    lblnbGeneral.setText(String.valueOf(nbGeneral));
                    generalList.add(newGeneral);
                });
            } else {
                btnadds.setOnMouseClicked(action -> {
                    SoldierItem newSoldier = new SoldierItem(txtsoldierName.getText(), sprank.getAccessibleRoleDescription(), txtvitalPoint.getText());
                    TreeItem newItem = new TreeItem<>(newSoldier);
                    treeItem.getChildren().add(newItem);
                    newItem.setValue(newSoldier.toString());
                    formPane.getChildren().remove(form);
                    lblnbSoldier.setText(String.valueOf(nbSoldier));
                    soldierList.add(newSoldier);
                });
            }

        });

    }


    //Event listener on treeview
    EventHandler<MouseEvent> mouseEventHandle = this::handleMouseClicked;

    //Actions when click detected
    private void handleMouseClicked(MouseEvent event) {
        // To know where the user clicks
        Node node = event.getPickResult().getIntersectedNode();
        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell<?>) node).getText() != null)){
            TreeItem<String> currentNode = tvarmy.getSelectionModel().getSelectedItem();
            //Test on what is selected
            String itemValue = currentNode.getValue();
            char test = itemValue.charAt(0);

            //Get TreeItem value to retrieve Instance of Item
            //String name = (String) ((TreeItem<?>)tvarmy.getSelectionModel().getSelectedItem()).getValue();

            clearForms();
            switch (test){
                case 'Y':
                    if(event.getButton()== MouseButton.SECONDARY){
                        addMenu(currentNode, addMenuItemG, addMenuG, test, generalForm, node);
                        currentNode.setExpanded(true);
                    }
                    break;
                case 'G':
                    if(event.getButton()== MouseButton.SECONDARY) {
                        addMenu(currentNode, addMenuItemS, addMenuS, test, soldierForm, node);
                        currentNode.setExpanded(true);
                        GeneralItem.getNbSoldier(currentNode);
                    }else if (event.getClickCount()==2) {
                        setModifyGeneralForm(currentNode);
                    }
                    break;
                case'S':
                    if (event.getClickCount()==2) {
                        setModifySoldierForm();
                    }
                    break;
            }
        }

    }

    public void setModifyGeneralForm(TreeItem item){
        clearForms();
        if(formPane.getChildren().isEmpty()) {
            formPane.getChildren().add(generalForm);
        }
        for(GeneralItem element: generalList) {
            if (item.getValue().equals(element.toString())) {
                System.out.println(element.getName());

            }
        }
        //Set all thing in the form in order to modify it
        //Disable Add and enable Modify button
        //Close form and update object


    }

    public void setModifySoldierForm(){
        clearForms();
        if(formPane.getChildren().isEmpty()) {
            formPane.getChildren().add(soldierForm);
        }


    }

    public void clearForms(){
        txtgeneralName.clear();
        txtsoldierName.clear();
        txtvitalPoint.clear();
        sprank.disarm();
    }



}

