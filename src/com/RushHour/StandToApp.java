package com.RushHour;

public class StandToApp{

    public void execute() {
        Display display = new Display();
        display.hello();

        Enemy boss1 = new Enemy(80, 80);
        Enemy boss2 = new Enemy(100, 100);
        Enemy boss3 = new Enemy(120, 120);

        // Go through loop and battle three bosses
        Enemy[] bosses = {boss1, boss2, boss3};
        for (int i = 0; i < bosses.length; i++) {
            Player player = new Player(bosses[i], 100, 100);
            boolean game = false;
            Battlefield battlefield = new Battlefield(player, bosses[i], game);
            System.out.println("Opponent: " + (i+1));
            System.out.println();
            display.showOpponent(i);
            battlefield.initializeBoard();
            while (!battlefield.isGameEnd()) {
                battlefield.menu();
            }
            if (player.getHealth() <= 0) {
                System.out.println("You have failed your comrades!");
                display.proceed();
                break;
            }
            display.showVictory();
            display.proceed();
        }
        display.gameEnd();
    }
}
