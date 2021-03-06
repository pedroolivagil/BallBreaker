package com.aquilesmobile.ballbreaker.Actors;

import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Oliva on 15/05/2015.
 */
public class HUD extends Group {

    private GeneralScreen screen;

    public HUD(GeneralScreen screen) {
        this.screen = screen;
        Image supBar = new Image(GameLogic.getImgSupBar());
        Image pause = new Image(GameLogic.getImgPause());
        Image form = new Image(GameLogic.getImgForm());

        int ancho = (int) GameLogic.resizeImg(supBar.getWidth(), supBar.getHeight(), GameLogic.getScreenWidth());
        float proporcion = ancho / supBar.getHeight();

        Gdx.app.log("Proporcion", "-----------> " + proporcion);
        supBar.setHeight(ancho);
        supBar.setWidth(GameLogic.getScreenWidth());

        pause.setHeight(pause.getHeight() * proporcion);
        pause.setWidth(pause.getWidth() * proporcion);

        form.setHeight(form.getHeight() * proporcion);
        form.setWidth(form.getWidth() * proporcion);

        supBar.setPosition(0, GameLogic.getScreenHeight() - supBar.getHeight());
        pause.setPosition(GameLogic.getScreenWidth() - pause.getWidth(), GameLogic.getScreenHeight() - pause.getHeight());
        form.setPosition(0, GameLogic.getScreenHeight() - form.getHeight());

        screen._stage.addActor(supBar);
        screen._stage.addActor(pause);
        screen._stage.addActor(form);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
