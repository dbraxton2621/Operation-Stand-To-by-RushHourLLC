package com.RushHour.client;

import com.RushHour.StandToApp;
import com.apps.util.SplashApp;

public class Main implements SplashApp {

    @Override
    public void start() {
        StandToApp app = new StandToApp();
        app.execute();
    }
    public static void main(String[] args) {
        Main startup = new Main();
        startup.welcome( "resources/rushhourlogo.png");
        startup.start();
    }
}
