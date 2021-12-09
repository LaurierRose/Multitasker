package com.example.multitasker.module.army;

public class SoldierItem extends GeneralItem {
    String rank;
    String PV;

    public SoldierItem(String name, String rank, String PV) {
        super(name);
        this.rank = rank;
        this.PV = PV;
    }

    //getter
    public String getRank() {
        return rank;
    }

    public String getPV() {
        return PV;
    }

    //setter
    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

}
