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
	public float totalTime;
	public int timer;
	
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
		
		generateNewChoice();
	}
	
	public void update () {
		int clicked = -1;
		if (Gdx.input.justTouched()) {
			totalTime = 10;
			timer = 1;
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if (choice1Bounds.contains(touchPoint.x, touchPoint.y)) {
				clicked = 0;
				current += number[clicked];
			}
			if (choice2Bounds.contains(touchPoint.x, touchPoint.y)) {
				clicked = 1;
				current -= number[clicked];
			}
			if (choice3Bounds.contains(touchPoint.x, touchPoint.y)) {
				clicked = 2;
				current *= number[clicked];
			}
			if (choice4Bounds.contains(touchPoint.x, touchPoint.y)) {
				clicked = 3;
				current /= number[clicked];
			}
			
			if (clicked != -1) {
				if (turn % 2 == 1) {
					showTurn--;
				}
				turn++;
				generateNewChoice();
			}
			
			if (turn == 21) {
				Gdx.app.exit();
			}
		}
	}
	
	public void generateNewChoice () {
		number[0] = rand.nextInt(30);
		while (current + number[0] >= 100) {
			number[0] = rand.nextInt(30);
		}
		
		number[1] = rand.nextInt(30);
		while (current - number[1] < 0) {
			number[1] = rand.nextInt(30);
		}
		
		number[2] = rand.nextInt(20);
		while (current * number[2] >= 100) {
			number[2] = rand.nextInt(20);
		}
		
		number[3] = rand.nextInt(8) + 1;
	}
	
}
