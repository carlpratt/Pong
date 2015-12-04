package com.cpratt.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cpratt.screens.GameScreen;

public class Ball {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    private float radius;

    private int screenWidth = GameScreen.SCREEN_WIDTH;
    private int screenHeight = GameScreen.SCREEN_HEIGHT;

    private int yMid = screenHeight / 2;
    private int ballRadius = 5;

    private Rectangle rect = new Rectangle(0, 102, 17, 12);
    private Circle ball = new Circle(ballRadius, yMid, ballRadius);

    public Ball(float x, float y, float radius) {
        this.radius = radius;

        position = new Vector2(x, y);     // Start Position
        velocity = new Vector2(100, 100); // Start Velocity
        acceleration = new Vector2(0, 0); // Start Acceleration (no acceleration currently)
    }

    /**
     * Detects collision with the screen bounds and inverts velocity and acceleration accordingly
     */
    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if ((position.x + radius) > screenWidth) {
            velocity.x *= -1;
            acceleration.x *= -1;
        }
        if ((position.x - radius) < 0) {
            velocity.x *= -1;
            acceleration.x *= -1;
        }
        if ((position.y + radius) > screenHeight) {
            velocity.y *= -1;
            acceleration.y *= -1;
        }
        if ((position.y - radius) < 0) {
            velocity.y *= -1;
            acceleration.y *= -1;
        }

        position.add(velocity.cpy().scl(delta));
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
}
