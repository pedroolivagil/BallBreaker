package com.aquilesmobile.ballbreaker.Actors;

import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.getBgScreen;

/**
 * Created by Oliva on 12/05/2015.
 */
public class Background extends Actor {

    GeneralScreen screen;

    public Background(GeneralScreen screen) {
        this.screen = screen;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(getBgScreen(), 0, 0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
