package com.RushHour;

import java.util.Scanner;

class Player {
    //instance variables (fields)
    public int soldiers = 100;
    private int health = 100;
    Scanner scanner = new Scanner(System.in);


    //constructors
    public Player(int soldiers, int health) {
        this.soldiers = soldiers;
        this.health = health;
    }

    //methods
    // TODO airstrike option in the future
    void goToStore() {
        System.out.println("     TRADE YOUR HEALTH FOR SOLDIERS     ");
        System.out.println("                   OR");
        System.out.println("                GET HEALTH");
        System.out.println("Current HP: " + getHealth());
        System.out.println("===**************Store***************===");
        System.out.println("     [H]ealth = +10    [S]oldiers +10   ");
        System.out.println("========================================");

        String userStoreInput = scanner.nextLine().toLowerCase();
        switch (userStoreInput) {
            case "h":
            case "Health":
                System.out.println("This will add +10 health to " + getHealth() + " .");
                int newHealth = getHealth() + 10;
                setHealth(newHealth);
                //update(health);
                break;

            case "s":
            case "Soldiers":
                System.out.println("This will add +10 soldiers to " + getSoldiers() + " .");
                int newSoldiers = getSoldiers() + 10;
                setSoldiers(newSoldiers);
                setHealth(getHealth()-10);
                //update(soldiers);
                break;

            default:
                System.out.println("Please provide a response.");
                goToStore();
                break;
        }
    }

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

