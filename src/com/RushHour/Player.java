package com.RushHour;

import java.util.Scanner;

class Player {
    //instance variables (fields)
    public int soldiers = 100;
    private int health = 100;
    Scanner scanner = new Scanner(System.in);
    private Player enemy;


    //constructors
    public Player(Player enemy, int soldiers, int health) {
        this.soldiers = soldiers;
        this.health = health;
        this.enemy = enemy;
    }

    //methods
    // TODO airstrike option in the future
    void goToStore() {
        System.out.println("     TRADE YOUR HEALTH FOR SOLDIERS     ");
        System.out.println("                   OR");
        System.out.println("                GET HEALTH");
        System.out.println("Current HP: " + getHealth());
        System.out.println("==========**************Store***************==========");
        System.out.println(" [H]ealth = +5 [S]oldiers +10 [A]irstrike -10 Enemy HP");
        System.out.println("======================================================");

        String userStoreInput = scanner.nextLine().toLowerCase();
        switch (userStoreInput) {
            case "h":
            case "Health":
                System.out.println("This will add +5 health to " + getHealth() + " .");
                addHealth(5);
                //update(health);
                break;

            case "s":
            case "Soldiers":
                System.out.println("This will add +10 soldiers to " + getSoldiers() + " .");
                addSoldiers(10);
                deductHealth(10);
                //update(soldiers);
                break;

            case "a":
            case "airstrike":
                System.out.println("This will deduct 10 health from " + enemy.getHealth() + " .");
                System.out.println("This also deducts 10 of your Soldiers from " + getSoldiers() + " .");
                enemy.deductHealth(10);
                deductSoldiers(10);
                //update(soldiers & enemy health);
                break;

            default:
                System.out.println("Please provide a response.");
                goToStore();
                break;

        }
    }

    public void deductHealth(int health) {
        setHealth(getHealth() - health);
    }

    public void addHealth(int health) {
        setHealth(getHealth() + health);
    }

    public void addSoldiers(int soldiers) {
        setSoldiers(getSoldiers() + soldiers);
    }

    public void deductSoldiers(int soldiers) {
        setSoldiers(getSoldiers() - soldiers);
    }

    //accessor methods
    public int getSoldiers() {
        return soldiers;
    }

    private void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Your Unit has, " + getSoldiers() + " Soldiers currently and base health is at " + getHealth() + " percent.";
    }

}

