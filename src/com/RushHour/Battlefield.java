package com.RushHour;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Battlefield {

    private Player player;
    private Enemy enemy;
    private int totalAmount = 0;
    private int[] playerLanes = new int[5];
    // Array Idea first
    //TODO maybe make a lane class
    private final Scanner scanner = new Scanner(System.in);
    private int[] enemyLanes = new int[5];
    private boolean gameEnd;



    // Constructor

    public Battlefield(Player player, Enemy enemy,boolean gameEnd) {
        this.player = player;
        this.enemy = enemy;
        this.gameEnd = gameEnd;
    }

    // Business Methods // Throws IllegalSoldierInputvalue
    // Controller class / maybe put it in another class for controller stuff only - standtoapp
    public void intialBoard() throws IllegalArgumentException{
        // The total amount changes without changing the original totalAmount
        totalAmount = player.getSoldiers();
        int total = totalAmount;
        for (int i = 0; i < playerLanes.length; i++) {
            // quick and easy check
            if(total < 0){
                throw new IllegalArgumentException("You done fucked up");
            }
            // When the loop hits the last index, the remainder should automatically be entered into that index
            if (i == 4) {
                playerLanes[i] = total;
                break;
            }
            // else we get the input from the user and check if its valid.
            // We put the amount into the lane and subtract it from the total
            System.out.println("Lane: " + (i + 1) + " Enter the amount of soldiers between 1 and " + total);
            // check for invalid input
            int soldiers = getValidNumber();
            //String input = scanner.nextLine();
            //int soldiers = Integer.parseInt(input);
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
        boolean validInput = false;
        try {
            while (validInput) {
                System.out.println("Enter a valid number");
                scanner.next();

            }
        } catch (Exception e) {
            System.out.println("Enter a valid response");
        }
        int result = scanner.nextInt();

        return result;
    }

    public void menu() {

        System.out.println("What would you like to do?");
        System.out.println("Current amount of soldiers: " + totalAmount);
        System.out.println("Required amount of soldiers: " + player.getSoldiers());
        System.out.println("Enemy: " + enemy.getHealth());
        System.out.println("Player: " + player.getHealth());
        System.out.println("========================================");
        System.out.println(" [U]pdate                     [P]lay");
        System.out.println("========================================");

        System.out.println("Your current Values");
        for (var item : playerLanes) {
            System.out.print("[" + item + "]");
        }
        System.out.println();
        String userInput = scanner.nextLine().toLowerCase();
        switch (userInput) {
            case "u":
            case "update":
                System.out.println("What Lane do you want to update");
                // needs to check if valid
                int lane = getValidNumber();
                lane -= 1;
                update(lane);
                break;

            case "p":
            case "play":
                if(totalAmount!=player.getSoldiers()){
                    System.out.println("Please fix your lanes");
                    menu();
                    break;
                }
                play();
                break;

            default:
                System.out.println("Enter a valid response");
                menu();
        }
    }

    private void checkForTotalSoldiers(int totalAmount, int requiredAmount) throws IllegalArgumentException{
        if(totalAmount!=requiredAmount){
            throw new IllegalArgumentException("Follow the directions");
        }
    }

    private void update(int lane) {
        // exception if user puts wrong lane


        System.out.println("Current Value for lane " + (lane + 1) + ": " + playerLanes[lane]);
        System.out.println("What do you want to change it to?");
        int update = getValidNumber();
        totalAmount -= playerLanes[lane];
        playerLanes[lane] = update;
        totalAmount += playerLanes[lane];
        menu();
    }

    private void play() {
        int laneNumber = (int) (Math.random() * 5);
        System.out.println("Chosen Lane: " + (laneNumber + 1));
        enemyLanes = enemy.generateEnemyLanes(enemy);
        for (var item : enemyLanes) {
            System.out.print("[" + item + "]");
        }
        System.out.println();




        // if dif is positive, subtract from enemy hp
        // if dif is neg, subtract from user hp
        //int chosenLane = rand
        int dif = ((int) playerLanes[laneNumber]) - ((int) enemyLanes[laneNumber]);
        // player wins, subtract dif from enemy health
        // subtract enemy lane soldiers from both sides
        if (dif > 0) {
            System.out.println("You won and did " + dif + " dmg");
            enemy.setHealth(enemy.getHealth() - dif);
            //enemy.setSoldiers(enemy.getSoldiers()-enemyLanes[i]);
            //player.setSoldiers(player.getSoldiers()-enemyLanes[i]);
        }
        else {
            // enemy wins
            // vice versa
            System.out.println("You lost and took " + dif + " dmg");
            player.setHealth(player.getHealth() - Math.abs(dif));
            //enemy.setSoldiers(enemy.getSoldiers()-playerLanes[i]);
            //player.setSoldiers(player.getSoldiers()-playerLanes[i]);
        }
        checkGameStatus(player,enemy);


    }

    private void checkGameStatus(Player player, Enemy enemy) {
        if(player.getHealth() < 0){
            System.out.println("you lost");
            setGameEnd(true);

        }
        else if(enemy.getHealth() < 0){
            System.out.println("You win");
            setGameEnd(true);
        }
        else{
            player.goToStore();
            menu();
        }
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

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}
