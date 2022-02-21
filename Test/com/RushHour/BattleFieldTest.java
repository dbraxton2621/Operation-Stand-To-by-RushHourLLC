package com.RushHour;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattleFieldTest {
    Player player;
    Enemy enemy;
    Battlefield battlefield;

    @Before
    public void init(){
        player = new Player(50,100);
        enemy = new Enemy(50,100);
        battlefield = new Battlefield(player, enemy);
    }

    @Test
    public void testMenu(){
        battlefield.menu();
    }

    @Test
    public void testInitialBoard(){
        battlefield.intialBoard();
        assertEquals(10, battlefield.getPlayerLanes()[0]);
    }
}