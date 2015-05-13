package com.aquilesmobile.ballbreaker.Screens;

import com.aquilesmobile.ballbreaker.BallBreakerGame;
import com.aquilesmobile.ballbreaker.Tools.GeneralScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.sql.DatabaseCursor;
import com.badlogic.gdx.sql.SQLiteGdxException;

import java.text.NumberFormat;

import static com.aquilesmobile.ballbreaker.Tools.GameLogic.*;

/**
 * Created by Oliva on 12/05/2015.
 */
public class ScoresScreen extends GeneralScreen {

    private Table tableScore;
    private Table scoresTable;
    private DatabaseCursor cursor;
    private DatabaseCursor maxScore;
    private NumberFormat nFormat;

    public ScoresScreen(BallBreakerGame game) {
        this.game = game;
    }

    @Override
    public void actionBackButton() {
        game.setScreen(game._mainMenuScreen);
    }

    @Override
    public void show() {
        super.show();
        contentScreen();
    }

    public void contentScreen() {
        Label title = new Label(game.getString().format("lHighScore"), getSkin());
        Label subTitle = new Label(game.getString().format("lTitle"), getSkin());
        Label otherScores = new Label(game.getString().format("lSubTitle"), getSkin());

        title.setColor(Color.ORANGE);
        title.setFontScale(1.5f);
        subTitle.setColor(Color.BLUE);

        scoresTable = new Table();

        tableScore = new Table();
        //tableScore.setFillParent(true);
        tableScore.setBackground(new TextureRegionDrawable(getBgBlackAlpha()));
        tableScore.setWidth(660);
        tableScore.setHeight(1050);
        tableScore.setOrigin(tableScore.getWidth() / 2, tableScore.getHeight() / 2);
        tableScore.setPosition(getScreenWidth() / 2 - tableScore.getOriginX(), getScreenHeight() / 2 - tableScore.getOriginY() + 20);

        tableScore.add(title).pad(20f);
        tableScore.row().padTop(60);
        tableScore.add(subTitle);
        tableScore.row().expand();
        tableScore.add(scoresTable).top();

        scoresTable.setWidth(tableScore.getWidth());

        String str_cursor = "SELECT score FROM " + game.TABLE_SCORE;
        String maxPoints = null;
        try {
            game.getDBHandler().openOrCreateDatabase();
            maxScore = game.getDBHandler().rawQuery("SELECT MAX(score) FROM " + game.TABLE_SCORE + ";");
            if (maxScore.next()) {
                maxPoints = maxScore.getString(0);
                str_cursor = str_cursor + " WHERE score != " + maxPoints;
            }
            str_cursor = str_cursor + " ORDER BY score DESC Limit 5;";

            Gdx.app.log("SELECT", "SELECT MAX(score) FROM " + game.TABLE_SCORE + ";  ----> " + maxPoints);
            Gdx.app.log("SELECT", str_cursor);

            cursor = game.getDBHandler().rawQuery(str_cursor);
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }

        if (((maxPoints == null) && (cursor == null))) {
            scoresTable.row().expand();
            scoresTable.add(new Label(game.getString().format("lNoScore"), getSkin()));
        } else {
            if (maxPoints != null) {
                Label max = new Label(nFormat.format(Double.parseDouble(maxPoints)), getSkin());
                max.setColor(Color.RED);
                max.setFontScale(1.7f);
                scoresTable.row().height(120).expandX().pad(30f).padTop(0).padBottom(20f);
                scoresTable.add(max).top();
            }
            if (maxPoints != null && cursor != null) {
                if (cursor.next()) {
                    scoresTable.row().expandX().pad(10f);
                    scoresTable.add(otherScores);
                    Label score;
                    do {
                        score = new Label(nFormat.format(cursor.getDouble(0)), getSkin());
                        score.setColor(Color.GRAY);
                        score.setFontScale(.8f);
                        scoresTable.row().expandX().pad(10f);
                        scoresTable.add(score);
                    } while (cursor.next());
                }
            }
        }

        try {
            maxScore.close();
            cursor.close();
            game.getDBHandler().closeDatabase();
        } catch (SQLiteGdxException e) {
            e.printStackTrace();
        }

        _stage.addActor(tableScore);
    }

    @Override
    public void dispose() {
        game._scoreScreen.dispose();
        super.dispose();
    }
}
