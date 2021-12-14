package com.example.multitasker.controller;

import com.example.multitasker.model.Book;
import com.example.multitasker.model.Library;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

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
    private Label messageLabel;

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
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button remove;

    @FXML
    private TableColumn<Book, String> releasedColumn;
    @FXML
    private TextField releasedField;

    @FXML
    private TableColumn<Book, String> rowColumn;

    @FXML
    private TextField rowField;

    @FXML
    private TextField searchField;

    @FXML
    private TextField urlField;

    @FXML
    private TableColumn<Book, String> summaryColumn;

    @FXML
    private TextArea summaryField;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField titleField;

    private Image defaultImg = new Image("file:src/main/resources/book-cover.png");

    private boolean edit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookCover.setImage(defaultImg);
        toggleFields(true);
        summaryField.setWrapText(true);
        messageLabel.setWrapText(true);
        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
        authorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAuthor()));
        releasedColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getReleased()));
        columnColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColumn()));
        rowColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRow()));
        summaryColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSummary()));

        bookTable.setItems(libList.getBooks());
        bookTable.getSortOrder().addAll(titleColumn);
        confirm.setOnMouseClicked(formAction -> {
            messageLabel.setText(fieldChecker());
            bookTable.getSortOrder().addAll(titleColumn);
            bookTable.refresh();
        });

        // Replaces book table with search results
        searchField.setOnKeyPressed(searchAction -> {
            if (!searchField.getText().isEmpty()) {
                String terms = searchField.getText();
                bookTable.setItems(libList.search(terms));
                bookTable.refresh();
            } else bookTable.setItems(libList.getBooks());
        });

        bookTable.setOnMouseClicked(listAction -> {
            showSelected();
            toggleFields(true);
            messageLabel.setText("");
        });

        bookTable.setOnKeyPressed(listAction -> {
            showSelected();
            toggleFields(true);
        });

        remove.setOnMouseClicked(removeAction -> {
            if (edit) {
                libList.remove(bookTable.getSelectionModel().getSelectedItem());
                clear();
                messageLabel.setTextFill(Color.GREEN);
                messageLabel.setText("Book removed successfully.");
                toggleFields(true);
            } else {
                messageLabel.setTextFill(Color.RED);
                messageLabel.setText("Please select a book to remove.");
            }
        });

        addButton.setOnMouseClicked(addAction -> {
            edit = false;
            clear();
            toggleFields(false);
        });

        editButton.setOnMouseClicked(editAction ->  {
            edit = true;
            toggleFields(false);
        });
    }

    public String fieldChecker() {
        // Checks if entered data is valid and returns message accordingly.
        String[] enteredDetails = {titleField.getText(), authorField.getText(), releasedField.getText(), columnField.getText(),
                rowField.getText(), summaryField.getText()};

        for (String i : enteredDetails) if (i.isEmpty()) {
            messageLabel.setTextFill(Color.RED);
            return "Please enter all mandatory fields.";
        }

        int column = 0;
        int row = 0;
        int released = 0;

        if (columnField.getText().matches("-?\\d+") && rowField.getText().matches("-?\\d+")) {
            column = Integer.parseInt(columnField.getText());
            row = Integer.parseInt(rowField.getText());
        }
        if (!(column > 0 && column < 6 && row > 0 && row < 8)) {
            messageLabel.setTextFill(Color.RED);
            return "Please enter valid Column (1-5) and Row (1-7) fields.";
        }
        if (releasedField.getText().matches("-?\\d+")) released = Integer.parseInt(releasedField.getText());
        if (released > Year.now().getValue() || released < 1500) {
            messageLabel.setTextFill(Color.RED);
            return "Please enter a valid release year.";
        }
        if (edit) {
            edit(enteredDetails, released, column, row, urlField.getText());
            messageLabel.setTextFill(Color.GREEN);
            toggleFields(true);
            return "Book has been edited.";
        } else {
            libList.add(enteredDetails, released, column, row, urlField.getText());
            messageLabel.setTextFill(Color.GREEN);
            toggleFields(true);
            bookTable.refresh();
            return "New book added successfully.";
        }
    }

    public void showSelected() {
        // Shows info from selected row.
        Book selected = bookTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        titleField.setText(selected.getTitle());
        authorField.setText(selected.getAuthor());
        releasedField.setText(selected.getReleased());
        columnField.setText(selected.getColumn());
        rowField.setText(selected.getRow());
        summaryField.setText(selected.getSummary());
        if (selected.getCover() != null && !selected.getCover().equals("")) {
            bookCover.setImage(new Image(selected.getCover()));
            urlField.setText(selected.getCover());
        } else {
            bookCover.setImage(defaultImg);
            urlField.setText("");
        }
    }

    public void clear() {
        // Clears all form fields.
        TextInputControl[] fields = {titleField, authorField, releasedField, columnField, rowField, summaryField, urlField};
        for (TextInputControl i : fields) i.setText("");
        bookCover.setImage(defaultImg);
        messageLabel.setText("");
    }

    public void edit(String[] details, int released, int column, int row, String url) {
        // Recover all form fields and sets them for selected book
        int selected = bookTable.getSelectionModel().getSelectedIndex();
        libList.getBooks().get(selected).setTitle(details[0]);
        libList.getBooks().get(selected).setAuthor(details[1]);
        libList.getBooks().get(selected).setReleased(released);
        libList.getBooks().get(selected).setColumn(column);
        libList.getBooks().get(selected).setRow(row);
        libList.getBooks().get(selected).setSummary(details[5]);
        libList.getBooks().get(selected).setCover(url);
    }

    public void toggleFields(boolean state) {
        // Switches form fields on and off.
        titleField.setDisable(state);
        authorField.setDisable(state);
        releasedField.setDisable(state);
        columnField.setDisable(state);
        rowField.setDisable(state);
        summaryField.setDisable(state);
        urlField.setDisable(state);
        remove.setDisable(state);
        confirm.setDisable(state);
    }
}