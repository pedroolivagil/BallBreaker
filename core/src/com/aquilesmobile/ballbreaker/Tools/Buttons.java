package com.aquilesmobile.ballbreaker.Tools;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Oliva on 12/05/2015.
 */
public class Buttons extends Actor {

    Label text;
    GeneralScreen screen;

    public Buttons(GeneralScreen screen, String str) {
        this.screen = screen;

        this.setPosition(0, 0);
        this.setOrigin(0, 0);
        this.setWidth(480);
        this.setHeight(144);
        this.setRotation(0);
        this.setScale(1);

        text = new Label(str, GameLogic.getSkin());
        text.setPosition(0, -100);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(GameLogic.getBgButton(), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        screen._stage.addActor(text);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        text.setPosition(this.getX(), this.getY());
    }
}
