package com.cpratt.gameworld;

import com.cpratt.gameobjects.Ball;
import com.cpratt.screens.GameScreen;

public class GameWorld {
    private int screenWidth = GameScreen.SCREEN_WIDTH;
    private int screenHeight = GameScreen.SCREEN_HEIGHT;

    private int yMid = screenHeight / 2;
    private int ballRadius = 5;

    private Ball ball;

    public GameWorld() {
        ball = new Ball(ballRadius, yMid, ballRadius);
    }

    /**
     * Calls the update functions for each game object.
     * Updates:
     * -Ball
     * -Paddle
     */
    public void update(float delta) {
        ball.update(delta);
    }

    public Ball getBall() {
        return ball;
    }
}
