package com.cpratt.gameworld;

import com.cpratt.gameobjects.Ball;
import com.cpratt.gameobjects.Paddle;
import com.cpratt.screens.GameScreen;

import java.util.concurrent.TimeUnit;

public class GameWorld {
    private int screenWidth = GameScreen.SCREEN_WIDTH;
    private int screenHeight = GameScreen.SCREEN_HEIGHT;

    private int yMid = screenHeight / 2;
    private int ballRadius = 5;

    private int paddleWidth = 10;
    private int paddleHeight = 50;

    private int paddleX = 10;
    private int paddleY = 10;

    private int computerPaddleX = screenWidth - 10 - paddleWidth;
    private int computerPaddleY = 10;

    private Ball ball;
    private Paddle paddle;
    private Paddle computerPaddle;

    private int playerScore = 0;
    private int computerScore = 0;

    public GameWorld() {
        ball = new Ball(ballRadius);
        paddle = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);
        computerPaddle = new Paddle(computerPaddleX, computerPaddleY, paddleWidth, paddleHeight);
    }

    /**
     * Calls the update functions for each game object.
     * Updates:
     * -Ball
     * -Paddles
     */
    public void update(float delta) {
        ball.update(delta, paddle, computerPaddle);
        paddle.update(delta);
        computerPaddle.update(delta);

        if (ball.isOutOfBoundsOnComputerSide()) {
            playerScore++;
            ball.reset();
        } else if (ball.isOutOfBoundsOnPlayerSide()) {
            computerScore++;
            ball.reset();
        }
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Paddle getComputerPaddle() {
        return computerPaddle;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}
