package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;

/**
 * Created by Oliva on 12/05/2015.
 */
public class GameOverScreen extends GeneralScreen {

    public GameOverScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        game._gameOverScreen.dispose();
        super.dispose();
    }
}
