package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.Actors.Background;
import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.Buttons;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getScreenHeight;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getScreenWidth;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getSkin;

/**
 * Created by Oliva on 12/05/2015.
 */
public class MainMenuScreen extends GeneralScreen {

    private Table tableMenu;
    //private TextButton bStart;
    private Buttons bStart;
    private TextButton bHScore;
    private TextButton bExit;
    private TextButton bPreference;

    public MainMenuScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        bStart = new Buttons(this, game.getString().format("lStart"));
        //bStart = new TextButton(game.getString().format("lStart"), getSkin());
        bHScore = new TextButton(game.getString().format("lHighScore"), getSkin());
        bPreference = new TextButton(game.getString().format("lMarket"), getSkin());
        bExit = new TextButton(game.getString().format("lExit"), getSkin());


        bHScore.pad(10).padLeft(20).padRight(20);
        bPreference.pad(10).padLeft(20).padRight(20);
        bExit.pad(10).padLeft(20).padRight(20);


        tableMenu = new Table();
        tableMenu.debug();
        tableMenu.setFillParent(true);
        tableMenu.setOrigin(getScreenWidth() / 2, getScreenHeight() / 2);
        tableMenu.setPosition(0, -getScreenHeight() / 4);
        // fila 1
        tableMenu.row();
        tableMenu.add(bStart).fillX().pad(10);
        //fila 2
        tableMenu.row();
        tableMenu.add(bHScore).fillX().pad(10);
        //fila 3
        tableMenu.row();
        tableMenu.add(bPreference).fillX().pad(10);
        //fila 4
        tableMenu.row();
        tableMenu.add(bExit).fillX().pad(10);

        _stage.addActor(new Background(this));
        _stage.addActor(tableMenu);

        addListeners();
    }

    private void addListeners() {
        bStart.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se hace click sobre el actor.
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se levanta el dedo del actor, se ejecuta solo cuando el touchDown es true.
                game.setScreen(game._gameScreen);
            }
        });
        bHScore.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se hace click sobre el actor.
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se levanta el dedo del actor, se ejecuta solo cuando el touchDown es true.
                game.setScreen(game._scoreScreen);
            }
        });
        bPreference.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se hace click sobre el actor.
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se levanta el dedo del actor, se ejecuta solo cuando el touchDown es true.
                game.setScreen(game._preferenceScreen);
            }
        });
        bExit.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se hace click sobre el actor.
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                //Se ejecuta cuando se levanta el dedo del actor, se ejecuta solo cuando el touchDown es true.
                Gdx.app.exit();
            }
        });
    }

    @Override
    public void dispose() {
        game._mainMenuScreen.dispose();
        super.dispose();
    }
}
