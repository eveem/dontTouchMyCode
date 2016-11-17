package com.monpriya.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

	private Texture backgroundImage;
	private Texture leftturnImage;
	private Texture rightturnImage;
	private Texture whitebarImage;
	private Texture turnNumber;
	private Texture choiceNumber;
	private Texture choiceImage;
	private Texture operatorShow;
	private Texture[] carryTexture = new Texture [2];
	private SpriteBatch batch;
	private World world;
	private String[] imageName = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private String[] operator = {"plus.jpg", "minus.jpg", "mul.jpg", "div.jpg"};
	private float choicePointX[] = {500, 900, 500, 900};
	private float choicePointY[] = {125, 125, 50, 50};
	
	public WorldRenderer (ProjectGame game, World world) {
		this.world = world;
		batch = game.batch;
		backgroundImage = new Texture("playScreen.jpg");
        leftturnImage = new Texture("leftTurn.jpg");
        rightturnImage = new Texture("rightTurn.jpg");
        whitebarImage = new Texture("whiteBar.jpg");
        choiceImage = new Texture("choice.jpg");
    }
	
	public void render () {
		float deltaTime = Gdx.graphics.getDeltaTime();
		world.totalTime -= deltaTime;
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		renderBackground();
		renderTurnBar();
//		renderTurnNumber();
		renderTask();
//		renderNowScore();
		renderChoice();
		batch.end();
    }
	
	public void renderBackground () {
		batch.draw(backgroundImage, 0, 0);
	}
	
	public void renderTurnBar () {
		world.timer += 1;
		if (world.turn % 2 == 0) {
			batch.draw(leftturnImage, 0, 628);
			batch.draw(whitebarImage, 600 + world.timer, 628);
			batch.draw(whitebarImage, 600 - world.timer, 628);
			if (world.timer < 0) {
				world.turn++;
				return ;
			}
		}
		else {
			batch.draw(whitebarImage, 0, 628);
			batch.draw(whitebarImage, 0 + world.timer, 628);
			batch.draw(rightturnImage, 600 + world.timer, 628);
			if (world.timer < 0) {
				world.turn++;
				return ;
			}
		}
	}
	
	public void renderTurnNumber () {
		if (world.showTurn == 10) {
        	turnNumber = new Texture(imageName[1]);
        	batch.draw(turnNumber, 543, 680);
        	turnNumber = new Texture(imageName[0]);
        	batch.draw(turnNumber, 598, 680);
        }
        else {
        	turnNumber = new Texture(imageName[world.showTurn % 10]);
        	batch.draw(turnNumber, 570, 680);
        }
		
		if (world.showTurn == 0) {
			batch.draw(whitebarImage, 0, 628);
			batch.draw(whitebarImage, 600, 628);

			Texture winScreen;
			if (world.current < world.task) {
				winScreen = new Texture("bluewin.jpg");
			}
			else if (world.current > world.task) {
				winScreen = new Texture("redwin.jpg");
			}
			else {
				winScreen = new Texture("draw.jpg");
			}
			batch.draw(winScreen, 0, 222);
		}
	}
	
	public void generateTexture (int number, String str) {
		carryTexture[0] = new Texture(imageName[number / 10] + str + ".jpg");
		carryTexture[1] = new Texture(imageName[number % 10] + str + ".jpg");
	}
	
	public void renderNowScore () {
//		generateTexture(world.current, now);
    	batch.draw(carryTexture[0], 235, 710);
    	batch.draw(carryTexture[1], 280, 710);
	}
	
	public void renderTask () {
		generateTexture(world.task, "task");
    	batch.draw(carryTexture[0], 335, 693);
    	batch.draw(carryTexture[1], 400, 693);
	}
	
	public void renderChoice () {
		batch.draw(choiceImage, 100, 90);
		for(int i = 0; i < 4; i++) {
			operatorShow = new Texture(operator[i]);
			batch.draw(operatorShow, choicePointX[i], choicePointY[i]);
			if (world.number[i]/10 != 0) {
				choiceNumber = new Texture(imageName[world.number[i] / 10] + ".jpg");
				batch.draw(choiceNumber, choicePointX[i] + 50, choicePointY[i]);
			}
			choiceNumber = new Texture(imageName[world.number[i] % 10] + ".jpg");
			batch.draw(choiceNumber, choicePointX[i] + 100, choicePointY[i]);
		}
	}
}
