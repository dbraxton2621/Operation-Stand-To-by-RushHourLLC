package com.RushHour;

public class StandToApp {
    public void execute() {
        Enemy boss1 = new Enemy(80, 80);
        Enemy boss2 = new Enemy(100, 100);
        Enemy boss3 = new Enemy(120, 120);

        Enemy[] bosses = {boss1, boss2, boss3};
        for (int i = 0; i <= bosses.length; i++) {
            Player player = new Player(100, 100);
            boolean game = false;
            Battlefield battlefield = new Battlefield(player, bosses[i], game);
            battlefield.initializeBoard();
            while (!battlefield.isGameEnd()) {
                battlefield.menu();
            }
            System.out.println("You won the war, who will be next?");
        }
    }
}
