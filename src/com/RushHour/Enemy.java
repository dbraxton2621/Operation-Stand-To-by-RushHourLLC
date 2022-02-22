package com.RushHour;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Player{

    public Enemy(int soldiers, int health) {
        super(soldiers, health);

        Enemy boss1 = new Enemy(80, 80);
        boss1.generateEnemyLanes(boss1);

        Enemy boss2 = new Enemy(90, 100);
        boss2.generateEnemyLanes(boss2);

        Enemy boss3 = new Enemy(110, 110);
        boss3.generateEnemyLanes(boss3);
    }


    public void generateEnemyLanes(Enemy enemy) {
        double[] enemyFront = {};
        int total = enemy.getSoldiers();
        double lane1 = Math.random() * total;
        double lane2 = Math.random() * (total - lane1);
        double lane3 = Math.random() * (total - (lane1 + lane2));
        double lane4 = Math.random() * (total - (lane1 + lane2 + lane3));
        double lane5 = total - (lane1 + lane2 + lane3 + lane4);
        enemyFront[0] = lane1;
        enemyFront[1] = lane2;;
        enemyFront[2] = lane3;;
        enemyFront[3] = lane4;;
        enemyFront[4] = lane5;;
    }

}
