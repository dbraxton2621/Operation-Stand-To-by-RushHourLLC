package com.RushHour;

import java.util.ArrayList;
import java.util.Scanner;


class Battlefield extends Player{
    private Scanner scanner = new Scanner(System.in);
    ArrayList<Integer> deployment = new ArrayList<>();

    public Battlefield(int soldiers, int health) {
        super(soldiers, health);
    }

    public void getPlayerChoice(){
        deployment.isEmpty();
        boolean validInput = false;
        while (deployment.size() < 5) { // 5 is the number of lanes
            System.out.print("Please enter 5 numbers equal to the number of your troops.");
            String input = scanner.nextLine();
            int choice = Integer.valueOf(input);
            if (input.matches()) {
                validInput = true;
                deployment.add(choice);
            }
        }
        return ;
    }


}
