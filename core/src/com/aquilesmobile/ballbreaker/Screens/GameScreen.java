package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.Actors.Background;
import com.aquilesmobile.ballbreaker.Actors.HUD;
import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;

/**
 * Created by OlivaDevelop on 12/05/2015.
 * <p/>
 * Pantalla de juego
 */
public class GameScreen extends GeneralScreen {

    public GameScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        _stage.addActor(new Background(this, GameLogic.getBackground2()));
        _stage.addActor(new HUD(this));
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
