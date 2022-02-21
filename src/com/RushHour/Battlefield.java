package com.RushHour;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


class Battlefield {
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private Enemy enemy;
    private int totalAmount = player.getSoldiers();
    // Array Idea first
    private int[] playerLanes = new int[5];
    private int[] enemyLanes = new int[5];

    // Business Methods // Throws IllegalSoldierInputvalue
    public void intialBoard(){
        boolean validInput = false;
        int total = totalAmount;
        for (int i = 0; i < playerLanes.length; i++){
            // magic number
            if(i==5){
                playerLanes[i] = total;
            }
            
            System.out.println("Lane: " + i + " Enter the amount of soldiers between 1 and " + total);
            // check for invalid input maybe in try catch
            int soldiers = getValidNumber();
            if(soldiers > total){
                // throw new IllegalSoldierInputValue
                System.out.println();
            }
            playerLanes[i] = soldiers;
            total -= soldiers;
        }
    }

    private int getValidNumber() {
        while(!scanner.hasNextInt()){
            System.out.println("Enter a valid number");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void menu(){
        
        System.out.println("What would you like to do?");
        System.out.println("Current amount of soldiers: " + totalAmount);
        System.out.println("Required amount of soldiers: " + player.getSoldiers());
        System.out.println("========================================");
        System.out.println(" [U]pdate        [S]tore       [P]lay");
        System.out.println("========================================");
        
        String userInput = scanner.nextLine().toLowerCase();
        switch(userInput){
            case "u":
            case "update":
                System.out.println("What Lane do you want to update");
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
        int update = scanner.nextInt();
        totalAmount -= playerLanes[lane];
        playerLanes[lane] = update;
        totalAmount += playerLanes[lane];
    }

    private void play() {
    }
}
