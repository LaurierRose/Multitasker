package com.example.multitasker.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ImcController implements Initializable {
    @FXML
    private Button BTN;

    @FXML
    private Label RESULT;

    @FXML
    private TextField inputCM;

    @FXML
    private TextField inputPOID;

    @FXML
    private Label lblCM;

    @FXML
    private Label lblIMC;

    @FXML
    private Label lblPOID;

    @FXML
    private Label infoRESULT;

    @FXML
    private Slider sliderIMC;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BTN.setOnMouseClicked(event -> {
            double cm = Double.parseDouble(inputCM.getText());
            double poid = Double.parseDouble(inputPOID.getText());
            double imc =  (poid / (cm * cm));
            RESULT.setText(String.format("%.1f", imc));

            sliderIMC.setValue(imc);

            //Slider
            if (imc < 18.5) {
                infoRESULT.setText("You are underweight");
            }
            if (imc >= 18.5 && imc <= 25) {
                infoRESULT.setText("You are normal");
            }
            if (imc > 25 && imc <= 30) {
                infoRESULT.setText("You are overweight");
            }
            if (imc > 30) {
                infoRESULT.setText("You are obese");
            }

            if (imc > 35 && imc <= 40) {
                infoRESULT.setText("You are seriously obese");
            }
            if (imc > 40) {
                infoRESULT.setText("You are morbidly obese");
            }



           /* //Label
            //arrondir à 2 chiffres après la virgule
            RESULT.setText(String.format("%.1f", imc));
            if (imc < 18.5) {
                infoRESULT.setText("You are underweight");
            }
            if (imc >= 18.5 && imc <= 25) {
                infoRESULT.setText("You are of normal build");
            }
            if (imc > 25 && imc <= 30) {
                infoRESULT.setText("you are overweight");
            }
            if (imc > 30 && imc <= 35) {
                infoRESULT.setText("You are obese");
            }
            if (imc > 35 && imc <= 40) {
                infoRESULT.setText("You are severely obese");
            }
            if (imc > 40) {
                infoRESULT.setText("You are morbidly obese");
            }*/


        });

}
}



