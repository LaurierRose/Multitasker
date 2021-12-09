package com.example.multitasker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BinaireController implements Initializable {
    @FXML
    private TextField deciToHexaTxt;

    @FXML
    private TextField hexaTxt;

    @FXML
    private TextField txtBinaire;

    @FXML
    private TextField txtDecimal;

    @FXML
    private TextField inputRoman;

    @FXML
    private Label lblTitleRoman;

    @FXML
    private Label resultRoman;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtBinaire.setOnKeyTyped(action -> {
            if (!txtBinaire.getText().isEmpty()) {
                txtDecimal.setText(binaryToDeci().toString());
            }
            else{}
        });
        txtDecimal.setOnKeyTyped(action -> {
            if (!txtDecimal.getText().isEmpty()) {
                txtBinaire.setText((deciToBinary()));
            }
            else {}

        });
        deciToHexaTxt.setOnKeyTyped(acion->{
            if(!deciToHexaTxt.getText().isEmpty()){
                hexaTxt.setText(deciToHexa());
            }
            else{}
        });



        //Roman convertor
        inputRoman.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int number = Integer.parseInt(newValue);
                resultRoman.setText(convert(number));
            } catch (NumberFormatException e) {
                resultRoman.setText("");
            }
        });



        hexaTxt.setOnKeyTyped(acion->{
            if(!hexaTxt.getText().isEmpty()){
                deciToHexaTxt.setText(hexaToDeci().toString());
            }
            else{}
        });


    }

    private Integer binaryToDeci() {
        int result = 0;
        String binaire = txtBinaire.getText();
        char[] listChar = binaire.toCharArray();
        int n = 0;
        try {
            for (int i = listChar.length - 1; i >= 0; i--) {
                if ((String.valueOf(listChar[i]).equals("1"))) {
                    result += Math.pow(2, n);

                }
                n++;
            }
        } catch (Exception exception) {

        }
        return result;
    }

    private String deciToBinary() {


        String decimal = txtDecimal.getText();
        String resultBin = "";
        int nbrDecimal = Integer.parseInt(decimal);
        ArrayList<Integer> binaryNum = new ArrayList<Integer>();

        int i = 0;
        try {
            while (nbrDecimal > 0) {

                binaryNum.add(nbrDecimal % 2);
                nbrDecimal = nbrDecimal / 2;
                i++;
            }
            for (int j = binaryNum.size() - 1; j >= 0; j--) {
                resultBin += binaryNum.get(j);
            }
        } catch (Exception exception) {

        }
        return resultBin;
    }

    private String deciToHexa(){
        String decimal = deciToHexaTxt.getText();
        int reste;
        String result = "";

        char charsOfHexadecimal[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        int nbrDecimal = Integer.parseInt(decimal);
try {
    while (nbrDecimal > 0) {
        reste = nbrDecimal % 16;
        result = charsOfHexadecimal[reste] + result;
        nbrDecimal = nbrDecimal / 16;
    }
} catch (Exception exception) {

}
        return result;


    }
    private Integer hexaToDeci(){
        char charsOfHexadecimal[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int n =0;
        int result = 0;
        String hexa = hexaTxt.getText();
        char[] listChar = hexa.toCharArray();
        System.out.println(listChar);
try {
    for (int i = listChar.length - 1; i >= 0; i--) {
        for (int j = 0; j < charsOfHexadecimal.length; j++) {
            if (listChar[i] == charsOfHexadecimal[j]) {
                result = (int) (result + j * Math.pow(16, n));
                n++;
            }
        }

    }
} catch (Exception exception) {

}
        return result;
    }
        //Roman method
    private String convert(int number) {
        String result = "";
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        try {
            for (int i = 0; i < numbers.length; i++) {
                while (number >= numbers[i]) {
                    result += roman[i];
                    number -= numbers[i];
                }
            }
        } catch (Exception exception) {

        }
        return result;
    }


        }
        






