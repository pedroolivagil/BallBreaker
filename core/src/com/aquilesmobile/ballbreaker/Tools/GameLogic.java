package com.aquilesmobile.ballbreaker.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Oliva on 15/04/2015.
 */
public abstract class GameLogic implements Disposable {
    /**
     * Constants *
     */
    private static int screenWidth;             // ancho de pantalla
    private static int screenHeight;            // alto de pantalla

    /**
     * Variables *
     */
    private static boolean pause = false;       // boolean de juego pausado

    /**
     * UI *
     */
    private static Skin skin;
    private static Texture splash;

    /**
     * HUD elements*
     */
    private static int level;
    private static int score;
    private static int lives;
    private static int totalLives;
    private static double timeGame;

    /**
     * Textures *
     */
    private static Texture bgBlackAlpha;
    private static Texture bgScreen;
    private static Texture bgButton;

    /**
     * Sounds *
     */

    public static void load() {
        // skin
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        // UI
        splash = new Texture("ui/logo.jpg");
        // Textures
        bgBlackAlpha = new Texture("ui/bg_negro.png");
        bgScreen = new Texture("ui/bg.png");
        bgButton = new Texture("ui/button.png");
    }

    /**
     * Getters y setters *
     */
    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        GameLogic.score = score;
    }

    public static void actScore(int score) {
        GameLogic.score += score;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameLogic.level = level;
    }

    public static void levelUp() {
        GameLogic.level++;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        GameLogic.lives = lives;
    }

    public static void lostLive() {
        GameLogic.lives--;
    }

    public static void addLive() {
        GameLogic.lives++;
    }

    public static int getTotalLives() {
        return totalLives;
    }

    public static void setTotalLives(int totalLives) {
        GameLogic.totalLives = totalLives;
    }

    public static boolean isPause() {
        return pause;
    }

    public static void setPause(boolean pause) {
        GameLogic.pause = pause;
    }

    public static double getTimeGame() {
        return timeGame;
    }

    public static void setTimeGame(double timeGame) {
        GameLogic.timeGame = timeGame;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(int screenWidth) {
        GameLogic.screenWidth = screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(int screenHeight) {
        GameLogic.screenHeight = screenHeight;
    }

    /**
     * UI getter y setters *
     */

    public static Skin getSkin() {
        return skin;
    }

    public static TextureRegion getSplash() {
        return new TextureRegion(splash, 0, 0, getScreenWidth(), getScreenHeight());
    }

    public static TextureRegion getBgBlackAlpha() {
        return new TextureRegion(bgBlackAlpha, 0, 0, 1, 1);
    }

    public static TextureRegion getBgScreen() {
        return new TextureRegion(bgScreen, 0, 0, getScreenWidth(), getScreenHeight());
    }

    public static TextureRegion getBgButton() {
        return new TextureRegion(bgButton, 0, 0, 480, 144);
    }

    @Override
    public void dispose() {
        skin.dispose();
        splash.dispose();
    }
}
