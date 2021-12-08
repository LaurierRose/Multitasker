package com.example.multitasker.module.army;

public class SoldierItem extends GeneralItem {
    String rank;
    int PV;
    int ID;

    public SoldierItem(String name) {
        super(name);
    }

    //getter
    public String getRank() {
        return rank;
    }

    public int getPV() {
        return PV;
    }

    //setter
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

}
