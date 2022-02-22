package com.RushHour;

public class StandToApp {

    public void execute() {
        Player player = new Player(100, 1);
        Enemy enemy = new Enemy(100, 1);
        boolean game = false;
        Battlefield battlefield = new Battlefield(player, enemy, game);

        play(battlefield);

        if(player.getHealth() > 0 ){

            enemy.setSoldiers(120);
            enemy.setHealth(120);
            player.setSoldiers(100);
            player.setHealth(100);
            game = false;

            battlefield = new Battlefield(player, enemy, game);

            play(battlefield);
        }
        System.out.println("done");
    }
    public void play(Battlefield battlefield){
        battlefield.initializeBoard();
        while (!battlefield.isGameEnd()) {
            battlefield.menu();
        }
    }

    /*
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

     */
}
