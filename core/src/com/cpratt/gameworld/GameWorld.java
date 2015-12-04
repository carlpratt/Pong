package com.cpratt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.cpratt.screens.GameScreen;

public class GameWorld {
    private int screenWidth = GameScreen.SCREEN_WIDTH;
    private int screenHeight = GameScreen.SCREEN_HEIGHT;

    private int yMid = screenHeight / 2;
    private int ballRadius = 5;

    private Rectangle rect = new Rectangle(0, 102, 17, 12);
    private Circle ball = new Circle(ballRadius, yMid, ballRadius);

    private int ballSpeedX = 2;
    private int ballSpeedY = 2;


    public void update(float delta) {
//        Gdx.app.log("GameWorld", "update");
        rect.x += 2;
        if (rect.x > 330) {
            rect.x = 0;
        }

        if ((ball.x + ball.radius) > screenWidth) {
            ballSpeedX = ballSpeedX * -1;
        }
        if ((ball.x - ball.radius) < 0) {
            ballSpeedX = ballSpeedX * -1;
        }
        if ((ball.y + ball.radius) > screenHeight) {
            ballSpeedY = ballSpeedY * -1;
        }
        if ((ball.y - ball.radius) < 0) {
            ballSpeedY = ballSpeedY * -1;
        }

        ball.x += ballSpeedX;
        ball.y += ballSpeedY;

    }

    public Rectangle getRect() {
        return rect;
    }

    public Circle getBall() {
        return ball;
    }
}
