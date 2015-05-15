package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;

/**
 * Created by OlivaDevelop on 12/05/2015.
 *
 * Pantalla de juego
 */
public class GameScreen extends GeneralScreen {

    public GameScreen(BallBreakerGame game) {
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
        game._gameScreen.dispose();
        super.dispose();
    }
}
