package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getSplash;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.load;

/**
 * Created by Oliva on 12/05/2015.
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
