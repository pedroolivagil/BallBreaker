package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.Actors.Background;
import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Oliva on 12/05/2015.
 */
public class MainMenuScreen extends GeneralScreen {


    public MainMenuScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        Image titulo = new Image(GameLogic.getImgTitulo());
        titulo.setHeight(GameLogic.resizeImg(titulo.getWidth(), titulo.getHeight(), 720));
        titulo.setWidth(720);
        titulo.setPosition(0, GameLogic.getScreenHeight() - titulo.getHeight());

        _stage.addActor(new Background(this));
        _stage.addActor(titulo);

        addListeners();
    }

    private void addListeners() {
    }

    @Override
    public void dispose() {
        game._mainMenuScreen.dispose();
        super.dispose();
    }
}
