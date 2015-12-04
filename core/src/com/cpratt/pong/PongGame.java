package com.cpratt.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.cpratt.screens.GameScreen;

/**
 * Main game class. Sets the following:
 * -Screen
 */
public class PongGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("Pong", "created");
        setScreen(new GameScreen());
	}
}
