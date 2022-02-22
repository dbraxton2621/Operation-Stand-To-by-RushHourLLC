package com.RushHour;

public class StandToApp {

    public void execute() {
        enemy1();

    }

    public void enemy1() {
        Player player = new Player(100, 100);
        Enemy enemy = new Enemy(100, 100);
        boolean game = false;
        Battlefield battlefield = new Battlefield(player, enemy, game);

        battlefield.initializeBoard();
        while (!battlefield.isGameEnd()) {
            battlefield.menu();
        }
        System.out.println("done");
    }
}
