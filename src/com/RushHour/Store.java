package com.RushHour;

public class Store{

    //instance variables (fields)
    public int addSoldiers = 10;
    public int addHealth = 10;

    //constructors


    public Store(int addSoldiers, int addHealth) {
        this.addSoldiers = addSoldiers;
        this.addHealth = addHealth;
    }


    public int soldiersNewValue = addSoldiers + Player.getSoldiers();
    public int healthNewValue = addHealth + Player.getHealth();

    public void setAddSoldiers(int addSoldiers) {
        this.addSoldiers = addSoldiers;
    }

    public void setAddHealth(int addHealth) {
        this.addHealth = addHealth;
    }

    public int getSoldiersNewValue() {
        return soldiersNewValue;
    }

    public void setSoldiersNewValue(int soldiersNewValue) {
        this.soldiersNewValue = soldiersNewValue;
    }

    public int getHealthNewValue() {
        return healthNewValue;
    }

    public void setHealthNewValue(int healthNewValue) {
        this.healthNewValue = healthNewValue;
    }



}
