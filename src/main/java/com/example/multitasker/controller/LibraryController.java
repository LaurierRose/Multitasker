package com.example.multitasker.controller;

import com.example.multitasker.module.Book;
import com.example.multitasker.module.Library;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TextField authorField;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<?, ?> columnColumn;

    @FXML
    private TextField columnField;

    @FXML
    private Button confirm;

    @FXML
    private TableColumn<?, ?> releasedColumn;

    @FXML
    private TextField releasedField;

    @FXML
    private TableColumn<?, ?> rowColumn;

    @FXML
    private TextField rowField;

    @FXML
    private TableColumn<?, ?> summaryColumn;

    @FXML
    private TextField summaryField;

    @FXML
    private TableColumn<String, String> titleColumn;

    @FXML
    private TextField titleField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Library books = new Library();

        confirm.setOnMouseClicked(formAction -> {
            String[] bookFields = {titleField.getText(), authorField.getText(), releasedField.getText(), columnField.getText(),
                    rowField.getText(), summaryField.getText()};

            for (String i : bookFields) {
                if (i.isEmpty()) {
                    System.out.println("Please enter all fields.");
                }
            }

            int column = 0;
            int row = 0;
            int released = 0;

            if (columnField.getText().matches("-?\\d+") && rowField.getText().matches("-?\\d+") &&
                    releasedField.getText().matches("-?\\d+")) {
                column = Integer.parseInt(columnField.getText());
                row = Integer.parseInt(rowField.getText());
                released = Integer.parseInt(releasedField.getText());
            } else {
                System.out.println("Please enter check Position and Released fields.");
            }

            if (column > 0 && column < 6 && row < 0 && row < 8 && released <= Year.now().getValue()) {
                books.add(bookFields, released, column, row);
            }

            bookTable.getItems();
        });



    }
}