package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.Actors.Background;
import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.Button;
import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Oliva on 12/05/2015.
 * <p/>
 * pantalla de menu principal
 */
public class MainMenuScreen extends GeneralScreen {

    Button btnStart;
    Button btnScore;
    Button btnOption;
    Button btnExit;

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

        float centrar = (GameLogic.getScreenWidth() / 2) - Button.getStaticWidth() / 2;
        int positionY = 500;

        btnStart = new Button(game.getString().format("lStart"));
        btnStart.setPosition(
                centrar,
                positionY
        );

        btnScore = new Button(game.getString().format("lHighScore"));
        btnScore.setFontScale(.8f);
        btnScore.setPosition(
                centrar,
                positionY - ((Button.getStaticHeight() * 1) + 10)
        );

        btnOption = new Button(game.getString().format("lOptions"));
        btnOption.setPosition(
                centrar,
                positionY - ((Button.getStaticHeight() * 2) + 20)
        );

        btnExit = new Button(game.getString().format("lExit"));
        btnExit.setPosition(
                centrar,
                positionY - ((Button.getStaticHeight() * 3) + 30)
        );

        _stage.addActor(new Background(this));
        _stage.addActor(titulo);
        _stage.addActor(btnStart);
        _stage.addActor(btnScore);
        _stage.addActor(btnOption);
        _stage.addActor(btnExit);

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
