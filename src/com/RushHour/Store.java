package com.RushHour;

class Store{

    //instance variables (fields)
    private int addSoldiers = 10;
    private int addHealth = 10;
    public int newSoldierValue;
    public int newHealthValue;

    //constructors
    public Store(int addSoldiers, int addHealth, int newSoldierValue, int newHealthValue) {
        this.addSoldiers = addSoldiers;
        this.addHealth = addHealth;
        this.newSoldierValue = newSoldierValue;
        this.newHealthValue = newHealthValue;

    }
    //Add 10 soldiers to whatever the current soldiers amount
    public void MoreSoldiers() {
       int newSoldiersValue = addSoldiers + Player.getSoldiers();
    }

    //Adds 10 health to whatever the current health amount
    public void MoreHealth() {
        int newSoldiersValue =  addHealth + Player.getHealth();
    }

    //G&S
    public int getNewSoldierValue() {
        return newSoldierValue;
    }

    public int getNewHealthValue() {
        return newHealthValue;
    }

    public void setNewSoldierValue(int newSoldierValue) {
        this.newSoldierValue = newSoldierValue;
    }


    public void setNewHealthValue(int newHealthValue) {
        this.newHealthValue = newHealthValue;
    }

}
