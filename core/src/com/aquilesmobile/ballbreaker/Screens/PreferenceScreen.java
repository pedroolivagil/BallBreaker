package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;

/**
 * Created by Oliva on 12/05/2015.
 *
 * pantalla de opciones
 */
public class PreferenceScreen extends GeneralScreen {

    public PreferenceScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dispose() {
        game._preferenceScreen.dispose();
        super.dispose();
    }
}
