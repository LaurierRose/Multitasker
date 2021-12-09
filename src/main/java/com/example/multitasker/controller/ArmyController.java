package com.example.multitasker.controller;

import com.example.multitasker.module.army.GeneralItem;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

        tvarmy.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);

        GeneralItem Gros = new GeneralItem("Gros");
        TreeItem newItem = new TreeItem<GeneralItem>(Gros);
        rootItem.getChildren().add(newItem);




        //Sur clic, créer l'objet General et ensuite créer l'item relié dans le treeview




    }

    private final ContextMenu addMenu = new ContextMenu();

    public void addGeneralMenu(TreeItem treeItem, MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();
        MenuItem addMenuItem = new MenuItem("Add");
        addMenu.getItems().add(addMenuItem);
        addMenu.show(node, 2, 4);
        addMenuItem.setOnAction((ActionEvent t) -> {
            GeneralItem Fat = new GeneralItem("Fat");
            TreeItem newItem = new TreeItem<GeneralItem>(Fat);
            treeItem.getChildren().add(newItem);
        });
    }

    EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
        handleMouseClicked(event);
    };

    private void handleMouseClicked(MouseEvent event) {
        //Node node = event.getPickResult().getIntersectedNode();
        // Accept clicks only on node cells, and not on empty spaces of the TreeView
        //if (node instanceof Text || (node instanceof TreeCell && ((TreeCell) node).getText() != null)) {
        String name = (String) ((TreeItem<?>)tvarmy.getSelectionModel().getSelectedItem()).getValue();
        System.out.println("Item click: " + name);
        addGeneralMenu(tvarmy.getSelectionModel().getSelectedItem(), event);

    }


}

