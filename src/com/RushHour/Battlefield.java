package com.RushHour;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Battlefield {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Enemy enemy;
    private int totalAmount = player.getSoldiers();
    // Array Idea first
    private int[] playerLanes = new int[5];
    private int[] enemyLanes = new int[5];

    // Constructor
    public Battlefield(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    // Business Methods // Throws IllegalSoldierInputvalue
    public void intialBoard() {
        // The total amount changes without changing the original totalAmount
        int total = totalAmount;
        for (int i = 0; i < playerLanes.length; i++) {
            // When the loop hits the last index, the remainder should automatically be entered into that index
            if (i == 4) {
                playerLanes[i] = total;
                break;
            }
            // else we get the input from the user and check if its valid.
            // We put the amount into the lane and subtract it from the total
            System.out.println("Lane: " + i + " Enter the amount of soldiers between 1 and " + total);
            // check for invalid input
            int soldiers = getValidNumber();
            if (soldiers > total) {
                // throw new IllegalSoldierInputValue
                System.out.println();
            }
            playerLanes[i] = soldiers;
            total -= soldiers;
        }
    }

    private int getValidNumber() {
        // check if the input is a number and is positive
        while (!scanner.hasNextInt() && Integer.parseInt(scanner.next()) >= 0) {
            System.out.println("Enter a valid number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void menu() {
        System.out.println("What would you like to do?");
        System.out.println("Current amount of soldiers: " + totalAmount);
        System.out.println("Required amount of soldiers: " + player.getSoldiers());
        System.out.println("========================================");
        System.out.println(" [U]pdate        [S]tore       [P]lay");
        System.out.println("========================================");
        String userInput = scanner.nextLine().toLowerCase();
        switch (userInput) {
            case "u":
            case "update":
                System.out.println("What Lane do you want to update");
                // needs to check if valid
                int lane = getValidNumber();
                update(lane);
                break;

            case "s":
            case "store":
                store();
                break;

            case "p":
            case "play":
                play();
                break;

            default:
                System.out.println("Enter a valid response");
                menu();
        }
    }

    private void store() {
    }

    private void update(int lane) {
        System.out.println("Current Value for lane " + lane + ": " + playerLanes[lane]);
        System.out.println("What do you want to change it to?");
        int update = getValidNumber();
        totalAmount -= playerLanes[lane];
        playerLanes[lane] = update;
        totalAmount += playerLanes[lane];

    }

    private void play() {
    }

    // Accessor Methods
    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int[] getPlayerLanes() {
        return playerLanes;
    }

    public int[] getEnemyLanes() {
        return enemyLanes;
    }
}
