package com.RushHour;

import java.util.*;
import java.util.Scanner;

class Player {
    //instance variables (fields)
    public int soldiers = 100;
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

    //Nested to uses Player
    public class Store {

        //instance variables (fields)
        Scanner scanner = new Scanner(System.in);
        public int moreSoldiers = 10;
        public int moreHealth = 10;

        //constructors
        public Store(int moreSoldiers, int moreHealth) {
            this.moreSoldiers = moreSoldiers;
            this.moreHealth = moreHealth;
        }
        /*
        void store() {
            System.out.println("===**************Store***************===");
            System.out.println("     [H]ealth = +10    [S]oldiers +10   ");
            System.out.println("========================================");

            String userStoreInput = scanner.nextLine().toLowerCase();
            switch (userStoreInput) {
                case "h":
                case "Health":
                    System.out.println("This will add +10 health to " + getHealth());
                    int newHealth = getHealth() + moreHealth;
                    update(health);
                    break;
                String userStoreInput = scanner.nextLine().toLowerCase();
                switch (userStoreInput) {
                    case "s":
                    case "Soldiers":
                        System.out.println("This will add +10 soldiers to" + getSoldiers());
                        int newHealth = getHealth() + moreHealth;
                        update(newhealth);
                        break;
                }

            }

         */
        }
    }
