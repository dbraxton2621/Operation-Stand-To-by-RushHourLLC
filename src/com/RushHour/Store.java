package com.RushHour;

import java.util.Scanner;

public class Store{

    //instance variables (fields)
    Scanner scanner = new Scanner(System.in);
    public int moreSoldiers = 10;
    public int moreHealth = 10;

    //constructors
    public Store(int moreSoldiers, int moreHealth) {
        this.moreSoldiers = moreSoldiers;
        this.moreHealth = moreHealth;
    }
    public void store() {
        System.out.println("    *************Store***************");
        System.out.println("========================================");
        System.out.println("     [H]ealth =+10    [S]oldiers +10 ");
        System.out.println("         =======================");

        String userStoreInput = scanner.nextLine().toLowerCase();
        switch (userStoreInput) {
            case "h":
            case "Health":
                System.out.println("This will add +10 health");
                int newHealth = Player.getHealth() + moreHealth;
                update(Player.health);
                break;

            case "s":
                System.out.println("This will add +10 soldiers");
                //New Value after add
                int newSoldiers = Player.getSoldiers() + moreSoldiers;
                update(Player.soldiers);
                break;

            default:
                menu();
        }
    }
}
