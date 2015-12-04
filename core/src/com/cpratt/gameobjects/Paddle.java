package com.cpratt.gameobjects;

import com.badlogic.gdx.math.Vector2;

public class Paddle {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation; // For handling bird rotation
    private int width;
    private int height;

    public Paddle(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

//        if ((position.x + ball.radius) > screenWidth) {
//            velocity.x = velocity.x * -1;
//        }
//        if ((position.x - ball.radius) < 0) {
//            velocity.x = velocity.x * -1;
//        }
//        if ((position.y + ball.radius) > screenHeight) {
//            velocity.y = velocity.y * -1;
//        }
//        if ((position.y - ball.radius) < 0) {
//            velocity.y = velocity.y * -1;
//        }
//
//        position.add(velocity.cpy().scl(delta));

    }

    public void onClick() {
//        velocity.y = -140;
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
}
