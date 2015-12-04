package com.cpratt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cpratt.gameobjects.Ball;
import com.cpratt.gameobjects.Paddle;
import com.cpratt.screens.GameScreen;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    // Game Objects
    private Ball ball;
    private Paddle paddle;
    private Paddle computerPaddle;

    SpriteBatch spriteBatch;
    BitmapFont font;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, GameScreen.SCREEN_WIDTH, GameScreen.SCREEN_HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        
        initGameObjects();
    }

    private void initGameObjects() {
        ball = myWorld.getBall();
        paddle = myWorld.getPaddle();
        computerPaddle = myWorld.getComputerPaddle();
    }

    public void render() {
//        Gdx.app.log("GameRenderer", "render");

        /*
         * 1. We draw a black background. This prevents flickering.
         */

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * 2. We draw the Ball
         */

        /** Renders BALL */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.circle(ball.getX(), ball.getY(), ball.getRadius());
        shapeRenderer.end();


        /** Renders PADDLE */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        shapeRenderer.end();

        /** Renders COMPUTER PADDLE */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(computerPaddle.getX(), computerPaddle.getY(), computerPaddle.getWidth(), computerPaddle.getHeight());
        shapeRenderer.end();


        /** Renders MIDDLE LINES */
        int y = 0;
        while((y + 7) < GameScreen.SCREEN_HEIGHT) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.rect(GameScreen.SCREEN_WIDTH / 2, y, 3, 7);
            shapeRenderer.end();
            y += 10;
        }


        /** Renders PLAYER SCORE */
        spriteBatch.begin();
        font.setColor(Color.WHITE); // Need to use the actual screen dimensions here for some reason
        font.draw(spriteBatch, Integer.toString(myWorld.getPlayerScore()),
                (Gdx.graphics.getWidth() / 2) - 40, Gdx.graphics.getHeight() - 20);
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, Integer.toString(myWorld.getComputerScore()),
                (Gdx.graphics.getWidth() / 2) + 40, Gdx.graphics.getHeight() - 20);
        spriteBatch.end();
    }
}
