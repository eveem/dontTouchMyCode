package com.monpriya.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class World {
	
	public int turn;
	public final Random rand;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	Rectangle choice1Bounds, choice2Bounds, choice3Bounds, choice4Bounds;
	
	public World (ProjectGame game) {
		rand = new Random();
		this.turn = 0;
		guiCam = new OrthographicCamera(800, 800);
		guiCam.position.set(800 / 2, 800 / 2, 0);
		choice1Bounds = new Rectangle(-102, -95, 222, 55);
		choice2Bounds = new Rectangle(-140, 180, 290, 55);
		choice3Bounds = new Rectangle(-40, -265, 95, 55);
		choice4Bounds = new Rectangle(-40, -265, 95, 55);
		touchPoint = new Vector3();
	}
	
	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			turn++;
//			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new GameScreen(game));
//				return;
//			}
//			if (howtoBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HowtoScreen(game));
//				return;
//			}
//			if (exitBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				Gdx.app.exit();
//			}
		}
	}
	
}
