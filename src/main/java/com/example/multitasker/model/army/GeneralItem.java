package com.example.multitasker.model.army;

import com.example.multitasker.controller.ArmyController;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TreeItem;

public class GeneralItem{
    private final SimpleStringProperty name;
    static int nbSoldiers = 0;

    public GeneralItem(String name) {
        this.name = new SimpleStringProperty(name);
        ++ArmyController.nbGeneral;
    }

    //Getter
    public String getName() {
        return name.get();
    }

    public static int getNbSoldiers() {
        return nbSoldiers;
    }

    //Setter
    public void setName(String newname) {
        name.set(newname);
    }

    public static void setNbSoldiers(int nbSoldiers) {
        GeneralItem.nbSoldiers = nbSoldiers;
    }

    @Override
    public String toString()  {
        return "General "+name.get();
    }


}
