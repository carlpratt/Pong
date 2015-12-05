package com.cpratt.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cpratt.screens.GameScreen;

import java.util.Random;

public class Ball {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float radius;

    private int screenWidth = GameScreen.SCREEN_WIDTH;
    private int screenHeight = GameScreen.SCREEN_HEIGHT;

    private int yMid = screenHeight / 2;
    private int ballRadius = 5;

    private Rectangle rect = new Rectangle(0, 102, 17, 12);
    private Circle boundingCircle = new Circle(ballRadius, yMid, ballRadius);

    private Random random = new Random();

    private boolean outOfBoundsOnPlayerSide = false;
    private boolean outOfBoundsOnComputerSide = false;

    private int startX = screenWidth / 2;
    private int startY = screenHeight / 2;

    public Ball(float radius) {
        this.radius = radius;

        int startVelocityX = calculateStartVelocityX();
        int startVelocityY = calculateStartVelocityY();

        position = new Vector2(startX, startY);
        velocity = new Vector2(startVelocityX, startVelocityY);
        acceleration = new Vector2(Math.signum(startVelocityX), Math.signum(startVelocityY));
    }

    /**
     * Detects collision with the screen bounds and inverts velocity and acceleration accordingly
     */
    public void update(float delta, Paddle paddle, Paddle computerPaddle) {

        velocity.add(acceleration.cpy().scl(delta));

        // Computer side
        if ((position.x + radius) > screenWidth && Math.signum(velocity.x) == 1) {
//            velocity.x *= -1;
//            acceleration.x *= -1;
            stopMoving();
            outOfBoundsOnComputerSide = true;
        }
        // Player Side
        if ((position.x - radius) < 0 && Math.signum(velocity.x) == -1) {
//            velocity.x *= -1;
//            acceleration.x *= -1;
            stopMoving();
            outOfBoundsOnPlayerSide = true;
        }
        if ((position.y + radius) > screenHeight && Math.signum(velocity.y) == 1) {
            velocity.y *= -1;
            acceleration.y *= -1;
        }
        if ((position.y - radius) < 0 && Math.signum(velocity.y) == -1) {
            velocity.y *= -1;
            acceleration.y *= -1;
        }

        if (collides(paddle) || collides(computerPaddle)) {
            velocity.x *= -1;
            acceleration.x *= -1;
        }

        position.add(velocity.cpy().scl(delta));

        updateBoundingCircle(position);
    }

    private void updateBoundingCircle(Vector2 position) {
        boundingCircle.setX(position.x);
        boundingCircle.setY(position.y);
    }

    public boolean collides(Paddle paddle) {
        if (Math.abs(position.x - paddle.getX()) < 10) {
            return Intersector.overlaps(getBoundingCircle(), paddle.getBoundingRectangle());
        }
        return false;
    }

    private void stopMoving() {
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 0;
    }

    public void reset() {
        position.x = startX;
        position.y = startY;
        velocity.x = calculateStartVelocityX();
        velocity.y = calculateStartVelocityY();
        acceleration.x = 0;
        acceleration.y = 0;

        outOfBoundsOnPlayerSide = false;
        outOfBoundsOnComputerSide = false;
    }

    private int calculateStartVelocityX() {
        return random.nextBoolean() ? 100 : -100;
    }

    private int calculateStartVelocityY() {
        return random.nextBoolean() ? 100 : -100;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getRadius() {
        return radius;
    }

    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public boolean isOutOfBoundsOnPlayerSide() {
        return outOfBoundsOnPlayerSide;
    }

    public boolean isOutOfBoundsOnComputerSide() {
        return outOfBoundsOnComputerSide;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }
}
