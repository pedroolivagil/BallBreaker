package com.aquilesmobile.ballbreaker;

import com.aquilesmobile.ballbreaker.Screens.GameOverScreen;
import com.aquilesmobile.ballbreaker.Screens.GameScreen;
import com.aquilesmobile.ballbreaker.Screens.MainMenuScreen;
import com.aquilesmobile.ballbreaker.Screens.PreferenceScreen;
import com.aquilesmobile.ballbreaker.Screens.ScoresScreen;
import com.aquilesmobile.ballbreaker.Screens.SplashScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseFactory;
import com.badlogic.gdx.sql.SQLiteGdxException;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.setScreenHeight;
import static com.aquilesmobile.ballbreaker.Tools.GameLogic.setScreenWidth;

/* Clase principal, el juego*/

public class BallBreakerGame extends Game {

    // Screens
    public Screen _splashScreen;
    public Screen _mainMenuScreen;
    public Screen _gameScreen;
    public Screen _scoreScreen;
    public Screen _gameOverScreen;
    public Screen _preferenceScreen;

    // Database
    private Database _dbHandler;

    // Configuracion para la base de datos
    private static final String DATABASE_NAME = "ballbreaker.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_SCORE = "scores";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE + "(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "score INTEGER NOT NULL," +
                    "date TEXT NULL," +
                    "time INTEGER NULL" + ");";

    private static I18NBundle myBundle;

    private void setLocation() {
        FileHandle baseFileHandle = Gdx.files.internal("i18n/BallBreakerLocation");
        myBundle = I18NBundle.createBundle(baseFileHandle, Locale.getDefault());
        Gdx.app.log("Locale", "Setted successfully");
    }

    private void createDB() {
        Gdx.app.log("DatabaseTest", "creation started");
        _dbHandler = DatabaseFactory.getNewDatabase(DATABASE_NAME, DATABASE_VERSION, DATABASE_CREATE, null);
        _dbHandler.setupDatabase();
        try {
            _dbHandler.openOrCreateDatabase();
            _dbHandler.execSQL(DATABASE_CREATE);
            _dbHandler.closeDatabase();
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }
        Gdx.app.log("DatabaseTest", "created successfully");
    }

    public static I18NBundle getStaticString() {
        return myBundle;
    }

    public I18NBundle getString() {
        return myBundle;
    }

    public Database getDBHandler() {
        return _dbHandler;
    }

    public BallBreakerGame() {
        setScreenWidth(720);
        setScreenHeight(1280);
    }

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
        Gdx.app.log("setScreen", "Screen charged successfully");
    }

    @Override
    public void create() {
        _splashScreen = new SplashScreen(this);
        _mainMenuScreen = new MainMenuScreen(this);
        _gameScreen = new GameScreen(this);
        _gameOverScreen = new GameOverScreen(this);
        _scoreScreen = new ScoresScreen(this);
        _preferenceScreen = new PreferenceScreen(this);

        createDB();
        setLocation();

        setScreen(_splashScreen);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
