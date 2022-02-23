package com.RushHour;

import com.apps.util.Console;

class Display extends Thread{

    public Display(){
        super();
    }

    public void displayBattle(){
        String tank1 = "         __,-.\n\\|_|    ( .`-')\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank2 = "        __,-.\n\\|_|    ( .`-')_.o\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank3 = "         ..,-.      _.--\"\"\"\"o\n\\|_|    : .`-';_.-\"\n|\"\"\"\\-=:. (.,.)\n(____)   `:-'";
        String tank4 = "        .. .       _.--\"\"\"\"--.\n\\|_|    : . : ; . \"             \"-.\n|\"\"\"\\-=:. :.,.;  " +
                "                  `.\n(____)   `.:'                        o";
        String[] tankDisplay = new String[]{tank1, tank2, tank3, tank4};
        for (String s : tankDisplay) {
            try {
                System.out.println(s);
                Thread.sleep(200);
                Console.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}