package com.example.multitasker.module.army;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class TextFieldTreeCellImpl extends TreeCell<String> {


    private final ContextMenu addMenu = new ContextMenu();

    public TextFieldTreeCellImpl() {
        MenuItem addMenuItem = new MenuItem("Add");
        addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction((ActionEvent t) -> {
            GeneralItem Gros = new GeneralItem("Gros");
            TreeItem newItem = new TreeItem<GeneralItem>(Gros);
            getTreeItem().getChildren().add(newItem);
        });
    }



    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setContextMenu(addMenu);

    }

}
