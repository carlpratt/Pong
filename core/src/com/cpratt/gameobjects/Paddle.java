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

        if (position.y <= 0 && Math.signum(velocity.y) == -1) {
            stopMoving();
        } else if (position.y >= GameScreen.SCREEN_HEIGHT - height && Math.signum(velocity.y) == 1) {
            stopMoving();
        }
    }

    public void updateAuto(float delta, Ball ball) {
        // Ball moving down, paddle should move down
        if (ball.getVelocity().y > 0 && ball.getPosition().y > (this.getY() + (this.height / 2))) {
            moveDownComputer();
        }
        // Ball moving down, paddle should move up
        if (ball.getVelocity().y > 0 && ball.getPosition().y < (this.getY() + (this.height / 2))) {
            moveUpComputer();
        }
        // Ball moving up, paddle should move down
        if (ball.getVelocity().y < 0 && ball.getPosition().y > (this.getY() + (this.height / 2))) {
            moveDownComputer();
        }
        // Ball moving down, paddle should move down
        if (ball.getVelocity().y < 0 && ball.getPosition().y < (this.getY() + (this.height / 2))) {
            moveUpComputer();
        }
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        updateBoundingRectangle(position);

        if (position.y <= 0 && Math.signum(velocity.y) == -1) {
            stopMoving();
        } else if (position.y >= GameScreen.SCREEN_HEIGHT - height && Math.signum(velocity.y) == 1) {
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
        if (position.y > 0) {
            velocity.y = -PADDLE_SPEED;
        }
    }

    public void moveDown() {
        if (position.y < GameScreen.SCREEN_HEIGHT - height) {
            velocity.y = PADDLE_SPEED;
        }
    }

    public void moveUpComputer() {
        if (position.y > 0) {
            velocity.y = -PADDLE_SPEED / 2;
        }
    }

    public void moveDownComputer() {
        if (position.y < GameScreen.SCREEN_HEIGHT - height) {
            velocity.y = PADDLE_SPEED / 2;
        }
    }

    public void stopMoving() {
        velocity.y = 0;
    }

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    // Only when x velocity is positive (going towards computer)
    private int calculateBallDestinationY(Ball ball) {
        float x = ball.getX();

        while (x < GameScreen.SCREEN_WIDTH) {

        }

        return 0;
    }
}
