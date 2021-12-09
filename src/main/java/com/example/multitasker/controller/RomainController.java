package com.example.multitasker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RomainController implements Initializable {

    @FXML
    private TextField inputNUMBERS;

    @FXML
    private Label lblNUMBERS;

    @FXML
    private Label romanRESULT;

    @FXML
    private Label titleCONVERT;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //convert numbers in roman numbers
        inputNUMBERS.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int number = Integer.parseInt(newValue);
                romanRESULT.setText(convert(number));
            } catch (NumberFormatException e) {
                romanRESULT.setText("");
            }
        });
    }

    private String convert(int number) {
        String result = "";
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < numbers.length; i++) {
            while (number >= numbers[i]) {
                result += roman[i];
                number -= numbers[i];
            }
        }
        return result;
    }

}




















