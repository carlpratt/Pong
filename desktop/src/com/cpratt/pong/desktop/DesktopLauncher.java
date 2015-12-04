package com.cpratt.pong.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cpratt.pong.PongGame;

/**
 * Launches the game and sets the following:
 * -Title
 * -Width and Height
 */

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pong";
		config.width = 660;
		config.height = 408;
		new LwjglApplication(new PongGame(), config);
	}
}
