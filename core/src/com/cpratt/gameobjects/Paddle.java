package com.cpratt.gameobjects;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cpratt.screens.GameScreen;

public class Paddle {

    private int PADDLE_SPEED = 150;

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    private Rectangle boundingRectangle;

    public Paddle(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);

        boundingRectangle = new Rectangle(x, y, width, height);
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        updateBoundingRectangle(position);

        if (position.y <= 0 || position.y >= GameScreen.SCREEN_HEIGHT - height) {
            stopMoving();
        }
    }

    private void updateBoundingRectangle(Vector2 position) {
        boundingRectangle.setX(position.x);
        boundingRectangle.setY(position.y);
    }

    public boolean collides(Ball ball) {
        if (Math.abs(position.x - ball.getX()) < 10) {
            return Intersector.overlaps(ball.getBoundingCircle(), boundingRectangle);
        }
        return false;
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

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }
}
