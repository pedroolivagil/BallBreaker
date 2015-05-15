package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getSplash;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.load;

/**
 * Created by Oliva on 12/05/2015.
 *
 * Pantalla Splash
 */
public class SplashScreen extends GeneralScreen {

    public SplashScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
        load();
        _stage.addActor(new Image(getSplash()));
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(game._mainMenuScreen);
            }
        }, 2.6f);
    }

    @Override
    public void dispose() {
        game._splashScreen.dispose();
        super.dispose();
    }
}
