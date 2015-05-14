package com.aquilesmobile.ballbreaker.Tools;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getScreenHeight;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getScreenWidth;

/**
 * Created by Oliva on 12/05/2015.
 */
public class GeneralScreen implements Screen {

    public BallBreakerGame game;
    public Stage _stage;

    public void actionBackButton() {

    }

    @Override
    public void show() {
        _stage = new Stage(new FitViewport(getScreenWidth(), getScreenHeight()));
        Gdx.input.setInputProcessor(_stage);
        Gdx.input.setCatchBackKey(true);
        _stage.addListener(new InputListener() {
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                if (keycode == Input.Keys.BACK || keycode == Input.Keys.ESCAPE) {
                    actionBackButton();
                }
                return super.keyUp(event, keycode);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        _stage.act(delta);
        _stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        _stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
