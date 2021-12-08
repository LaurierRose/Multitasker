package com.example.multitasker.module.army;

public class Soldier extends General{
    String rank;
    int PV;
    int ID;

    public Soldier(String name, int newID, String newrank, int newPV) {
        super(name);
        this.ID = newID;
        this.rank = newrank;
        this.PV = newPV;
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
