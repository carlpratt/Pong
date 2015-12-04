package com.cpratt.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Paddle {

    private int PADDLE_SPEED = 150;

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    public Paddle(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        position.add(velocity.cpy().scl(delta));

    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void moveUp() {
        velocity.y = -PADDLE_SPEED;
    }

    public void moveDown() {
        velocity.y = PADDLE_SPEED;
    }

    public void stopMoving() {
        velocity.y = 0;
    }
}
