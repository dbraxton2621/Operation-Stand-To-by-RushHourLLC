package com.RushHour;

public class StandToApp {

    public void execute() {
        Player player = new Player(100,100);
        Enemy enemy = new Enemy(100,100);
        boolean game = false;
        Battlefield battlefield = new Battlefield(player, enemy, game);

        battlefield.intialBoard();
        while(!battlefield.isGameEnd()){
            battlefield.menu();
        }
        System.out.println("done");
    }
}
