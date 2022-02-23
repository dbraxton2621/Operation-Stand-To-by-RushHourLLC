package com.RushHour;

import com.apps.util.Console;
import com.apps.util.SplashApp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

class Display extends Thread implements SplashApp {
Scanner scanner = new Scanner(System.in);

    public Display() {
        super();
    }

    public void welcome() {
        //TODO let's find a way to show Zakee's artwork
        String title = "                                                                                                                                             \n" +
                " @@@@@@  @@@@@@@  @@@@@@@@ @@@@@@@   @@@@@@  @@@@@@@ @@@  @@@@@@  @@@  @@@     @@@@@@ @@@@@@@  @@@@@@  @@@  @@@ @@@@@@@     @@@@@@@  @@@@@@  \n" +
                "@@!  @@@ @@!  @@@ @@!      @@!  @@@ @@!  @@@   @!!   @@! @@!  @@@ @@!@!@@@    !@@       @!!   @@!  @@@ @@!@!@@@ @@!  @@@      @!!   @@!  @@@ \n" +
                "@!@  !@! @!@@!@!  @!!!:!   @!@!!@!  @!@!@!@!   @!!   !!@ @!@  !@! @!@@!!@!     !@@!!    @!!   @!@!@!@! @!@@!!@! @!@  !@!      @!!   @!@  !@! \n" +
                "!!:  !!! !!:      !!:      !!: :!!  !!:  !!!   !!:   !!: !!:  !!! !!:  !!!        !:!   !!:   !!:  !!! !!:  !!! !!:  !!!      !!:   !!:  !!! \n" +
                " : :. :   :       : :: ::   :   : :  :   : :    :    :    : :. :  ::    :     ::.: :     :     :   : : ::    :  :: :  :        :     : :. :  \n" +
                "                                                                                                                                             \n";
        System.out.println();
        System.out.println(title);
        System.out.println("Press any key and enter to continue.");
        continueText();
        Console.clear();
        showRuleSet();
    }

    public void continueText() {
        String input = scanner.nextLine();
        switch (input){
            default:
                break;
        }
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
        System.out.println("Press any key and enter to continue");
        continueText();
        Console.clear();
    }

    public void displayBattle() {
        String tank1 = "         __,-.\n\\|_|    ( .`-')\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank2 = "        __,-.\n\\|_|    ( .`-')_.o\n|\"\"\"\\-=(_ (_,_)\n(____)   `--'";
        String tank3 = "         ..,-.      _.--\"\"\"\"o\n\\|_|    : .`-';_.-\"\n|\"\"\"\\-=:. (.,.)\n(____)   `:-'";
        String tank4 = "        .. .       _.--\"\"\"\"--.\n\\|_|    : . : ; . \"             \"-.\n|\"\"\"\\-=:. :.,.;  " +
                "                  `.\n(____)   `.:'                        o";
        String[] tankDisplay = new String[]{tank1, tank2, tank3, tank4};
        for (String s : tankDisplay) {
            try {
                System.out.println(s);
                Thread.sleep(500);
                Console.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}