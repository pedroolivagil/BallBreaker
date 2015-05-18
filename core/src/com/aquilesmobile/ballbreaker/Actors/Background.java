package com.aquilesmobile.ballbreaker.Actors;

import com.aquilesmobile.ballbreaker.Tools.GameLogic;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Oliva on 12/05/2015.
 */
public class Background extends Actor {

    GeneralScreen screen;
    TextureRegion tRegion;

    public Background(GeneralScreen screen, TextureRegion tRegion) {
        this.screen = screen;
        this.tRegion = tRegion;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(tRegion, 0, 0, GameLogic.getScreenWidth(), GameLogic.getScreenHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
