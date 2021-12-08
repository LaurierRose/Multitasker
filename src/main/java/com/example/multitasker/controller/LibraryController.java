package com.example.multitasker.controller;

import com.example.multitasker.module.Book;
import com.example.multitasker.module.Library;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    private Library libList = new Library();

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TextField authorField;

    @FXML
    private ImageView bookCover;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> columnColumn;

    @FXML
    private TextField columnField;

    @FXML
    private Button confirm;

    @FXML
    private TableColumn<Book, String> releasedColumn;

    @FXML
    private TextField releasedField;

    @FXML
    private TableColumn<Book, String> rowColumn;

    @FXML
    private TextField rowField;

    @FXML
    private TableColumn<Book, String> summaryColumn;

    @FXML
    private TextField summaryField;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField titleField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        titleColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getTitle())));
        authorColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getAuthor())));
        releasedColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getAuthor())));
        columnColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getColumn())));
        rowColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getRow())));
        summaryColumn.setCellValueFactory((cellData -> new SimpleStringProperty(cellData.getValue().getSummary())));

        bookTable.setItems(libList.getBooks());

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

            if (column > 0 && column < 6 && row > 0 && row < 8 && released <= Year.now().getValue()) {
                libList.add(bookFields, released, column, row);
            }



        });



    }
}