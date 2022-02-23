package com.RushHour;

import com.apps.util.Console;
import com.apps.util.SplashApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

class Display  {
Scanner scanner = new Scanner(System.in);

    public Display() {
        super();
    }

    public void welcome() {
        //TODO let's find a way to show Zakee's artwork
        // get it into a file and put into resources
        String title = "                                                                                                                                             \n" +
                " @@@@@@  @@@@@@@  @@@@@@@@ @@@@@@@   @@@@@@  @@@@@@@ @@@  @@@@@@  @@@  @@@     @@@@@@ @@@@@@@  @@@@@@  @@@  @@@ @@@@@@@     @@@@@@@  @@@@@@  \n" +
                "@@!  @@@ @@!  @@@ @@!      @@!  @@@ @@!  @@@   @!!   @@! @@!  @@@ @@!@!@@@    !@@       @!!   @@!  @@@ @@!@!@@@ @@!  @@@      @!!   @@!  @@@ \n" +
                "@!@  !@! @!@@!@!  @!!!:!   @!@!!@!  @!@!@!@!   @!!   !!@ @!@  !@! @!@@!!@!     !@@!!    @!!   @!@!@!@! @!@@!!@! @!@  !@!      @!!   @!@  !@! \n" +
                "!!:  !!! !!:      !!:      !!: :!!  !!:  !!!   !!:   !!: !!:  !!! !!:  !!!        !:!   !!:   !!:  !!! !!:  !!! !!:  !!!      !!:   !!:  !!! \n" +
                " : :. :   :       : :: ::   :   : :  :   : :    :    :    : :. :  ::    :     ::.: :     :     :   : : ::    :  :: :  :        :     : :. :  \n" +
                "                                                                                                                                             \n";
        System.out.println();
        System.out.println(title);
        proceed();
        Console.clear();
        showRuleSet();
    }

    public void proceed() {
        System.out.println("Press [Enter] to continue.");
        String input = scanner.nextLine();
    }

    public void showRuleSet() {
        // Do a fileReader and read from the text file
        // Display it for the user to see
        String path = "resources/ruleSet.txt";
        if(Files.exists(Path.of("resources/ruleSet.txt"))){
            try{
                List<String> lines = Files.readAllLines(Path.of(path));
                for (String line : lines){
                    System.out.println(line);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        };
        proceed();
        Console.clear();
    }

    public void displayBattle() {
        //TODO move to resources
        // for(int i = 0 to 3) {
        //      tankDisplay[i] = Files.readString(Path.of("resources/tank" + i + ".txt"));
        String tank0 = "         __,-.\n\\|_|    ( .`-')\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank1 = "        __,-.\n\\|_|    ( .`-')_.o\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank2 = "         ..,-.      _.--\"\"\"\"o\n\\|_|    : .`-';_.-\"\n|\"\"\"\\-=:. (.,.)\n(____)   `:-'";
        String tank3 = "        .. .       _.--\"\"\"\"--.\n\\|_|    : . : ; . \"             \"-.\n|\"\"\"\\-=:. :.,.;  " +
                "                  `.\n(____)   `.:'                        o";

        String[] tanks = {tank0, tank1, tank2, tank3};
        for (String tank : tanks) {
            try {
                System.out.println(tank);
                Thread.sleep(750);
                Console.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}