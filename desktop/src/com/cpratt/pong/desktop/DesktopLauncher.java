package com.cpratt.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cpratt.pong.PongGame;
import com.cpratt.screens.GameScreen;

/**
 * Launches the game and sets the following:
 * -Title
 * -Width and Height
 */

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pong";
		config.width = GameScreen.SCREEN_WIDTH * 2; // correct for ortho camera
		config.height = GameScreen.SCREEN_HEIGHT * 2;
		new LwjglApplication(new PongGame(), config);
	}
}
