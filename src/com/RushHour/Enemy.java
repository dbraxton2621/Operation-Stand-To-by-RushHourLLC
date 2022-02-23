package com.RushHour;



public class Enemy extends Player{

    public Enemy(int soldiers, int health) {
        super(null, soldiers, health); // Enemy does not have reference to player...
    }

    public int[] generateLanes() {
        int[] enemyFront = new int[5];
        int total = this.getSoldiers();
        int lane1 =(int) (Math.random() * total);
        int lane2 =(int) (Math.random() * (total - lane1));
        int lane3 =(int) (Math.random() * (total - (lane1 + lane2)));
        int lane4 =(int) (Math.random() * (total - (lane1 + lane2 + lane3)));
        int lane5 =(int) (total - (lane1 + lane2 + lane3 + lane4));
        enemyFront[0] = lane1;
        enemyFront[1] = lane2;;
        enemyFront[2] = lane3;;
        enemyFront[3] = lane4;;
        enemyFront[4] = lane5;;
        return enemyFront;
    }

}
