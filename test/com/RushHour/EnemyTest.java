package com.RushHour;

import org.junit.Test;

public class EnemyTest {

    @Test
    public void getRandomEnemyDispo() {
        Enemy boss1 = new Enemy(100, 100);
        boss1.generateEnemyLanes(boss1);
    }
}
