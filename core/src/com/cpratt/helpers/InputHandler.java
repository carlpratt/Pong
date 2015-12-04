package com.cpratt.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.cpratt.gameobjects.Paddle;

public class InputHandler implements InputProcessor {

    private Paddle paddle;

    public InputHandler(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case 19:
                Gdx.app.log("InputHandler", "Up Arrow Down");
                paddle.moveUp();
                break;
            case 20:
                Gdx.app.log("InputHandler", "Down Arrow Down");
                paddle.moveDown();
                break;
            case 21:
                Gdx.app.log("InputHandler", "Left Arrow Down");
                break;
            case 22:
                Gdx.app.log("InputHandler", "Right Arrow Down");
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 19:
                Gdx.app.log("InputHandler", "Up Arrow Up");
                paddle.stopMoving();
                break;
            case 20:
                Gdx.app.log("InputHandler", "Down Arrow Up");
                paddle.stopMoving();
                break;
            case 21:
                Gdx.app.log("InputHandler", "Left Arrow Up");
                break;
            case 22:
                Gdx.app.log("InputHandler", "Right Arrow Up");
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
