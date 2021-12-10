package com.example.multitasker.module.army;

import com.example.multitasker.controller.ArmyController;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TreeItem;

public class GeneralItem{
    private SimpleStringProperty name;
    static int nbSoldiers;

    public GeneralItem(String name) {
        this.name = new SimpleStringProperty(name);
        ArmyController.nbGeneral++ ;
    }

    //Getter
    public String getName() {
        return name.get();
    }

    //Setter

    public void setName(String newname) {
        name.set(newname);
    }

    @Override
    public String toString()  {
        return "General "+name.get();
    }


    //Define number of soldiers of this General
    public static int getNbSoldier(TreeItem<String> treeItem){
        int number = treeItem.getChildren().size();
        nbSoldiers = number;
        return number;
    }


}
