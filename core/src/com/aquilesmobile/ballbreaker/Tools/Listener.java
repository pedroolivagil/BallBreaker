package com.aquilesmobile.ballbreaker.Tools;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Oliva on 15/05/2015.
 */
public class Listener extends InputListener {
    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        action();
        super.touchUp(event, x, y, pointer, button);
    }

    public void action(){

    }
}
