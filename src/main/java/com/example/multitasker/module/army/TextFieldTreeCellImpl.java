package com.example.multitasker.module.army;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class TextFieldTreeCellImpl extends TreeCell<String> {

    private TextField textField;
    private final ContextMenu addMenu = new ContextMenu();

    public TextFieldTreeCellImpl() {
        MenuItem addMenuItem = new MenuItem("Add Employee");
        addMenu.getItems().add(addMenuItem);
        addMenuItem.setOnAction((ActionEvent t) -> {
            TreeItem newItem = new TreeItem<>("New Item");
            getTreeItem().getChildren().add(newItem);
        });
    }

    @Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }
        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText((String) getItem());
        setGraphic(getTreeItem().getGraphic());
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setContextMenu(addMenu);
        if (empty) {
            setContextMenu(addMenu);
            //setText(null);
            //setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    setContextMenu(addMenu);
                    //textField.setText(getString());
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(getTreeItem().getGraphic());
                if (
                        !getTreeItem().isLeaf()&&getTreeItem().getParent()== null
                ){
                    setContextMenu(addMenu);
                }
            }
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setOnKeyReleased((KeyEvent t) -> {
            if (t.getCode() == KeyCode.ENTER) {
                commitEdit(textField.getText());
            } else if (t.getCode() == KeyCode.ESCAPE) {
                cancelEdit();
            }
        });

    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
