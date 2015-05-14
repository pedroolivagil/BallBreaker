package com.aquilesmobile.ballbreaker.Tools;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Oliva on 14/05/2015.
 * <p/>
 * Actor que genera un label y una imagen y los superpone para realizar el efecto del boton
 */
public class Button extends Group {

    private Label lbText;

    /**
     * @param text para el texto del boton
     */
    public Button(String text) {
        generate(text, GameLogic.getImgButton());
    }

    /**
     * @param text     para el texto del boton
     * @param btnImage para cambiar la imagen del boton
     */
    public Button(String text, TextureRegion btnImage) {
        generate(text, btnImage);
    }

    private void generate(String text, TextureRegion img) {
        lbText = new Label(text, GameLogic.getSkin());
        Image iButton = new Image(img);

        iButton.setOrigin(iButton.getWidth() / 2, iButton.getHeight() / 2);
        lbText.setOrigin(lbText.getWidth() / 2, lbText.getHeight() / 2);

        iButton.setScale(.6f);
        iButton.setPosition(this.getX(), this.getY());

        lbText.setPosition(
                iButton.getX() + iButton.getOriginX() - lbText.getOriginX(),
                iButton.getY() + iButton.getOriginY() - lbText.getOriginY()
        );

        addActors(iButton, lbText);
    }

    @Override
    public void setColor(Color color) {
        lbText.setColor(color);
    }

    public void addActors(Actor actor1, Actor actor2) {
        if (this.hasChildren()) {
            this.clearChildren();
        }
        addActor(actor1);
        addActor(actor2);
    }
}
