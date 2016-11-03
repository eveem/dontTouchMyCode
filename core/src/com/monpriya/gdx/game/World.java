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
	public int current;
	public int number[] = new int [4];
	
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
		current = 0;
		
		number[0] = rand.nextInt(50);
		number[1] = rand.nextInt(50);
		number[2] = rand.nextInt(10);
		number[3] = rand.nextInt(10);
	}
	
	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if (choice1Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				if(turn%2==1) {
					showTurn--;
				}
				turn++;
				current += number[0];
				
				number[0] = rand.nextInt(50);
				number[1] = rand.nextInt(50);
				number[2] = rand.nextInt(10);
				number[3] = rand.nextInt(10);
			}
			if (choice2Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				if(turn%2==1) {
					showTurn--;
				}
				turn++;
				current -= number[1];
				
				number[0] = rand.nextInt(50);
				number[1] = rand.nextInt(50);
				number[2] = rand.nextInt(10);
				number[3] = rand.nextInt(10);
			}
			if (choice3Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				if(turn%2==1) {
					showTurn--;
				}
				turn++;
				current *= number[2];
				
				number[0] = rand.nextInt(50);
				number[1] = rand.nextInt(50);
				number[2] = rand.nextInt(10);
				number[3] = rand.nextInt(10);
			}
			if (choice4Bounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				if(turn%2==1) {
					showTurn--;
				}
				turn++;
				current /= number[3];
				
				number[0] = rand.nextInt(50);
				number[1] = rand.nextInt(50);
				number[2] = rand.nextInt(10);
				number[3] = rand.nextInt(10);
			}
			if(showTurn == 0) {
				return;
			}
		}
	}
	
}
