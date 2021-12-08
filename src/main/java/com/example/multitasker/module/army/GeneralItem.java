package com.example.multitasker.module.army;

import javafx.scene.control.TreeItem;

public class GeneralItem extends TreeItem {
    String name;
    int nbSoldiers;

    public GeneralItem(String name) {
        this.name = name;
    }

    //Getter
    public String getName() {
        return name;
    }

    public int getNbSoldiers() {
        return nbSoldiers;
    }

    //Setter

    public void setName(String name) {
        this.name = name;
    }

    /*
    public int getNbSoldier(){
        //Check number of childsItem in treeView
        return number;
    }
    Define number of soldiers of this General
     */

}
