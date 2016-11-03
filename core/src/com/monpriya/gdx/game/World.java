package com.monpriya.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class World {
	
	public int turn;
	public int showTurn;
	public final Random rand;
	OrthographicCamera guiCam;
	Vector3 touchPoint;
	Rectangle choice1Bounds, choice2Bounds, choice3Bounds, choice4Bounds;
	public int task;
	
	public World (ProjectGame game) {
		rand = new Random();
		this.turn = 0;
		this.showTurn = 10;
		guiCam = new OrthographicCamera(800, 800);
		guiCam.position.set(800 / 2, 800 / 2, 0);
		choice1Bounds = new Rectangle(-130, -295, 260, 100);
		choice2Bounds = new Rectangle(130, -295, 260, 100);
		choice3Bounds = new Rectangle(-130, -390, 260, 100);
		choice4Bounds = new Rectangle(130, -390, 260, 100);
		touchPoint = new Vector3();
		task = rand.nextInt(100);
	}
	
	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			System.out.println(touchPoint.x);
			System.out.println(touchPoint.y);
			if (choice1Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				turn++;
			}
			if (choice2Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				turn++;
			}
			if (choice3Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				turn++;
			}
			if (choice4Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				turn++;
			}
			if(turn%2==0) {
				showTurn--;
			}
			if(turn<=0) {
				return;
			}
		}
	}
	
}
