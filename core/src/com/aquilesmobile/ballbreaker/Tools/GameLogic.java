package com.aquilesmobile.ballbreaker.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Oliva on 15/04/2015.
 *
 * Clase que contiene la logica y las texturas del juego
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
    private static Texture titulo;
    private static Texture bg1;
    private static Texture bg2;
    private static Texture bg3;
    private static Texture button;

    /**
     * Sounds *
     */

    public static void load() {
        // skin
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        // UI
        splash = new Texture("ui/logo.jpg");
        // Textures
        titulo = new Texture("ui/title.png");
        bg1 = new Texture("ui/bg/Background01.png");
        bg2 = new Texture("ui/bg/Background02.png");
        bg3 = new Texture("ui/bg/Background03.png");
        button = new Texture("ui/button.png");
    }

    public static float resizeImg(float anchoOriginal, float altoOriginal, float anchoDeseado) {
        return (anchoDeseado * altoOriginal) / anchoOriginal;
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

    public static TextureRegion getImgTitulo() {
        return new TextureRegion(titulo, 0, 0, 903, 517);
    }

    public static TextureRegion getBackground1() {
        return new TextureRegion(bg1, 0, 0, bg1.getWidth(), bg1.getHeight());
    }

    public static TextureRegion getBackground2() {
        return new TextureRegion(bg2, 0, 0, bg2.getWidth(), bg2.getHeight());
    }

    public static TextureRegion getBackground3() {
        return new TextureRegion(bg3, 0, 0, bg3.getWidth(), bg3.getHeight());
    }

    public static TextureRegion getImgButton() {
        return new TextureRegion(button, 0, 0, 474, 194);
    }

    @Override
    public void dispose() {
        skin.dispose();
        splash.dispose();
    }
}
