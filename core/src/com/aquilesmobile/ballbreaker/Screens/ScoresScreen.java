package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;

/**
 * Created by Oliva on 12/05/2015.
 */
public class ScoresScreen extends GeneralScreen {

    public ScoresScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void actionBackButton() {
        game.setScreen(game._mainMenuScreen);
    }

    @Override
    public void show() {
        super.show();
        contentScreen();
    }

    public void contentScreen() {
    }

    @Override
    public void dispose() {
        game._scoreScreen.dispose();
        super.dispose();
    }
}
