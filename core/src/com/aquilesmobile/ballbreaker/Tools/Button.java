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
    Image iButton;
    private static float width = GameLogic.getImgButton().getRegionWidth();
    private static float height = GameLogic.getImgButton().getRegionHeight();

    /**
     * @param text para el texto del boton
     */
    public Button(String text) {
        generate(text, GameLogic.getImgButton());
    }

    public static float getStaticWidth() {
        return Button.width;
    }

    public static float getStaticHeight() {
        return Button.height;
    }

    public void setFontScale(float scale) {
        lbText.setFontScale(scale);
        lbText.setWidth(lbText.getWidth() * scale);
        lbText.setHeight(lbText.getHeight() * scale);
    }

    private void generate(String text, TextureRegion img) {
        iButton = new Image(img);
        lbText = new Label(text, GameLogic.getSkin());

        this.setWidth(iButton.getWidth());
        this.setHeight(iButton.getHeight());

        iButton.setOrigin(iButton.getWidth() / 2, iButton.getHeight() / 2);
        lbText.setOrigin(lbText.getWidth() / 2, lbText.getHeight() / 2);
        iButton.setPosition(this.getX(), this.getY());

        addActors(iButton, lbText);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        lbText.setPosition(
                iButton.getX() + iButton.getOriginX() - lbText.getWidth() / 2,
                iButton.getY() + 20 + iButton.getOriginY() - lbText.getHeight() / 2
        );
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
