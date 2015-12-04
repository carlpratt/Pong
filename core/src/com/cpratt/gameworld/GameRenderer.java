package com.cpratt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cpratt.screens.GameScreen;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, GameScreen.SCREEN_WIDTH, GameScreen.SCREEN_HEIGHT);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
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
        // Tells shapeRenderer to begin drawing filled shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Chooses RGB Color of 87, 109, 120 at full opacity
        shapeRenderer.setColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);

        // Draws the circle from myWorld (Using ShapeType.Filled)
        shapeRenderer.circle(myWorld.getBall().getX(), myWorld.getBall().getY(), myWorld.getBall().getRadius());

        // Tells the shapeRenderer to finish rendering
        // We MUST do this every time.
        shapeRenderer.end();


        /** Renders PADDLE */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
        shapeRenderer.rect(myWorld.getPaddle().getX(), myWorld.getPaddle().getY(), myWorld.getPaddle().getWidth(), myWorld.getPaddle().getHeight());
        shapeRenderer.end();

        /** Renders COMPUTER PADDLE */
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
        shapeRenderer.rect(myWorld.getComputerPaddle().getX(), myWorld.getComputerPaddle().getY(),
                myWorld.getComputerPaddle().getWidth(), myWorld.getComputerPaddle().getHeight());
        shapeRenderer.end();
    }
}
