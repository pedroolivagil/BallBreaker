package com.aquilesmobile.ballbreaker.desktop;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = GameLogic.getScreenWidth();
        config.height = GameLogic.getScreenHeight();
        new LwjglApplication(new BallBreakerGame(), config);
    }
}
