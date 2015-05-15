package com.aquilesmobile.ballbreaker.Actors;

import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Oliva on 15/05/2015.
 */
public class HUD extends Actor {

    private GeneralScreen screen;

    public HUD(GeneralScreen screen) {
        this.screen = screen;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
