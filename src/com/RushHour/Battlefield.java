package com.RushHour;

import com.apps.util.Console;

import java.util.Scanner;


public class Battlefield {
    private final Player player;
    private final Enemy enemy;
    private int totalAmount = 0;
    private final int[] playerLanes = new int[5];
    private final Scanner scanner = new Scanner(System.in);
    private int[] enemyLanes = new int[5];
    private boolean gameEnd;
    private final Display display = new Display();
    // Constructor
    public Battlefield(Player player, Enemy enemy,boolean gameEnd) {
        this.player = player;
        this.enemy = enemy;
        this.gameEnd = gameEnd;
    }

    // Business Methods // Throws IllegalSoldierInputValue
    public void initializeBoard() {
        Console.clear();
        // The total amount changes without changing the original totalAmount
        totalAmount = player.getSoldiers();
        int total = totalAmount;
        for (int i = 0; i < playerLanes.length; i++) {
            // quick and easy check
            if(total < 0){
                System.out.println("You have over stretched your capabilities.");
                initializeBoard();
                break;
            }
            // When the loop hits the last index, the remainder should automatically be entered into that index
            if (i == 4) {
                playerLanes[i] = total;
                break;
            }
            System.out.println("Lane: " + (i + 1) + " Enter the amount of soldiers between 0 and " + total);
            // else we get the input from the user and check if it's valid.
            int soldiers = getValidNumber();
            // We put the amount into the lane and subtract it from the total
            playerLanes[i] = soldiers;
            total -= soldiers;
        }
        Console.clear();
    }

    private int getValidNumber() {
        // check if the input is a number and is positive
        int selection = 0;
        boolean validInput = false;
            while (!validInput) {
                String input = scanner.nextLine();
                if (input.matches("\\d{1,2}")) {
                    selection = Integer.parseInt(input);
                    if (0 <= selection && selection <= totalAmount) {
                        validInput = true;
                    }
                }
            }
        return selection;
    }

    public void menu() {
        Console.clear();
        int i = 1;
        System.out.println("What would you like to do?");
        System.out.println("Current amount of soldiers: " + totalAmount);
        System.out.println("Required amount of soldiers: " + player.getSoldiers());
        System.out.println("Enemy HP: " + enemy.getHealth());
        System.out.println("Player HP: " + player.getHealth());
        System.out.println();
        System.out.println("========================================");
        System.out.println(" [U]pdate        [P]lay        [R]ules  " );
        System.out.println("========================================");

        System.out.println("Your current Lane Values");
        for (var item : playerLanes) {
            System.out.println("Lane " + i + ": [" + item + "]");
            i++;
        }
        System.out.println();
        String userInput = scanner.nextLine().toLowerCase();
        switch (userInput) {
            case "u":
            case "update":
                System.out.println("What Lane do you want to update?");
                // needs to check if valid
                int lane = getValidNumber();
                lane -= 1;
                update(lane);
                break;

            case "p":
            case "play":
                if(totalAmount!=player.getSoldiers()){
                    Console.clear();
                    System.out.println("Please fix your lane total.");
                    display.proceed();
                    menu();
                    break;
                }
                play();
                break;
            case "r":
            case "rules":
                display.showRuleSet();
                menu();
                break;
            default:
                System.out.println("Enter a valid response");
                menu();
        }
    }

    private void update(int lane) {
        // exception if user puts wrong lane
        if (lane > playerLanes.length) {
            System.out.println("Enter a valid lane.");
            display.proceed();
            menu();
        }
        System.out.println("Current Value for lane " + (lane + 1) + ": " + playerLanes[lane]);
        System.out.println("What do you want to change it to?");
        int update = getValidNumber();
        totalAmount -= playerLanes[lane];
        playerLanes[lane] = update;
        totalAmount += playerLanes[lane];
        menu();
    }

    private void play() {
        Console.clear();
        display.displayBattle();
        int laneNumber = (int) (Math.random() * 5);
        System.out.println("Chosen Lane: " + (laneNumber + 1));
        enemyLanes = enemy.generateLanes();
        System.out.println("Your value: " + playerLanes[laneNumber]);
        System.out.println("Enemy value: " + enemyLanes[laneNumber]);
        System.out.println();

        // if dif is positive, subtract from enemy hp
        // if dif is neg, subtract from user hp
        //int chosenLane = rand
        int dif = ( playerLanes[laneNumber]) - ( enemyLanes[laneNumber]);
        // player wins, subtract dif from enemy health
        // subtract enemy lane soldiers from both sides
        if (dif > 0) {
            System.out.println("You did " + dif + " dmg!");
            enemy.deductHealth(dif);
        } else if (dif < 0){
            // enemy wins
            System.out.println("You took " + dif + " dmg!");
            player.deductHealth(Math.abs(dif));
        } else {
            System.out.println("The fight was a draw and zero damage was taken.");
        }
        checkGameStatus(player,enemy);
    }

    private void checkGameStatus(Player player, Enemy enemy) {
        if(player.getHealth() <= 0 || enemy.getHealth() <= 0){
            setGameEnd(true);
        } else{
            display.proceed();
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
