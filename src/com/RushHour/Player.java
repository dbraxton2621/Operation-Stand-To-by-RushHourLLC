package com.RushHour;

class Player {
    //instance variables (fields)
    private int soldiers = 100;
    private int health = 100;

    //constructors
    public Player(int soldiers, int health) {
        this.soldiers = soldiers;
        this.health = health;
    }

    //methods

    //accessor methods
    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Your Unit has, " + getSoldiers() + " Soldiers currently and base health is at " + getHealth() + " percent.";
    }
}
