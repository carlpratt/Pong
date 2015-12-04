package com.cpratt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 330, 204);
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
         * 2. We draw the Filled rectangle
         */

//        // Tells shapeRenderer to begin drawing filled shapes
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//
//        // Chooses RGB Color of 87, 109, 120 at full opacity
//        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//
//        // Draws the rectangle from myWorld (Using ShapeType.Filled)
//        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
//                myWorld.getRect().width, myWorld.getRect().height);
//
//        // Tells the shapeRenderer to finish rendering
//        // We MUST do this every time.
//        shapeRenderer.end();
//
//        /*
//         * 3. We draw the rectangle's outline
//         */
//
//        // Tells shapeRenderer to draw an outline of the following shapes
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//
//        // Chooses RGB Color of 255, 109, 120 at full opacity
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//
//        // Draws the rectangle from myWorld (Using ShapeType.Line)
//        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
//                myWorld.getRect().width, myWorld.getRect().height);
//
//        shapeRenderer.end();


//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//        shapeRenderer.triangle(myWorld.getRect().x, myWorld.getRect().y,
//                myWorld.getRect().x + myWorld.getRect().width, myWorld.getRect().y,
//                myWorld.getRect().x + (myWorld.getRect().width / 2), myWorld.getRect().y - myWorld.getRect().height);
//        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 1);
        shapeRenderer.circle(myWorld.getBall().x, myWorld.getBall().y, myWorld.getBall().radius);
        shapeRenderer.end();
    }
}
