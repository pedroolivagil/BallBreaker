package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.Actors.Background;
import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.Button;
import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.graphics.Color;
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
        titulo.setHeight(GameLogic.resizeImg(titulo.getWidth(), titulo.getHeight(), 700));
        titulo.setWidth(700);
        titulo.setPosition(
                GameLogic.getScreenWidth() / 2 - titulo.getWidth() / 2,
                GameLogic.getScreenHeight() - titulo.getHeight() - 50
        );

        Button btnStart = new Button(game.getString().format("lStart"));
        btnStart.setPosition(
                0,
                500
        );
        btnStart.setColor(Color.MAGENTA);

        _stage.addActor(new Background(this));
        _stage.addActor(titulo);
        _stage.addActor(btnStart);

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
