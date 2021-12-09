package com.example.multitasker.module.army;

import com.example.multitasker.MainApplication;
import com.example.multitasker.controller.ArmyController;
import javafx.beans.property.SimpleStringProperty;

public class GeneralItem{
    private SimpleStringProperty name;
    int nbSoldiers = 0;

    public GeneralItem(String name) {
        this.name = new SimpleStringProperty(name);
        ArmyController.nbGeneral++ ;
    }

    //Getter
    public String getName() {
        return name.get();
    }

    public int getNbSoldiers() {
        return nbSoldiers;
    }

    //Setter

    public void setName(String newname) {
        name.set(newname);
    }

    @Override
    public String toString()  {
        return name.get();
    }

    /*
    public int getNbSoldier(){
        //Check number of childsItem in treeView
        return number;
    }
    Define number of soldiers of this General
     */

}
