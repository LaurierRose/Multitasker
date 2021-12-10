package com.example.multitasker.module.army;

import com.example.multitasker.controller.ArmyController;
import javafx.beans.property.SimpleStringProperty;

public class SoldierItem {
    private SimpleStringProperty name;
    String rank;
    String PV;

    public SoldierItem(String name, String rank, String PV) {
        this.name = new SimpleStringProperty(name);
        this.rank = rank;
        this.PV = PV;
        ArmyController.nbSoldier++ ;
    }

    //getter

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getPV() {
        return PV;
    }

    //setter
    public void setName(String name) {
        this.name.set(name);
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

    @Override
    public String toString()  {
        return "Soldier "+rank+" "+name.get()+" "+PV;
    }

}
