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
String path = "";

    public Display() {
        super();
    }

    public void welcome() {

        setPath("resources/welcomeBanner.txt");
        getPathReturn(getPath());
        showRuleSet();
    }
    public void getPathReturn(String path){
        if(Files.exists(Path.of(path))){
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

    public void proceed() {
        System.out.println("Press [Enter] to continue.");
        String input = scanner.nextLine();
    }

    public void showRuleSet() {

        setPath("resources/ruleSet.txt");
        getPathReturn(getPath());
    }

    public void displayBattle() {

        String[] tankDisplay = new String[5];
        for (int i = 0; i < tankDisplay.length; i ++){
            try{
                tankDisplay[i] = Files.readString(Path.of("resources/tank"+i+".txt"));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        for (String tank : tankDisplay) {
            try {
                System.out.println(tank);
                Thread.sleep(750);
                Console.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameEnd() {
        setPath("resources/endBanner.txt");
        getPathReturn(getPath());
    }

    public void showOpponent(int i) {
        if(i == 0){
            setPath("resources/opponent0.txt");
            getPathReturn(getPath());
        }
        else if (i == 1){
            setPath("resources/opponent1.txt");
            getPathReturn(getPath());
        }
        else{
            setPath("resources/opponent2.txt");
            getPathReturn(getPath());
        }
    }

    public void showVictory() {
        setPath("resources/victoryBanner.txt");
        getPathReturn(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}