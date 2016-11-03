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
	private Texture turnImage;
	private Texture nowImage;
	private Texture taskNumber;
	private Texture taskImage;
	private SpriteBatch batch;
	private World world;
	private String[] imageName = {"zero.jpg", "one.jpg", "two.jpg", "three.jpg", "four.jpg", "five.jpg", "six.jpg", "seven.jpg", "eight.jpg", "nine.jpg"};
	
	public WorldRenderer (ProjectGame game, World world) {
		this.world = world;
		batch = game.batch;
		backgroundImage = new Texture("playScreen.jpg");
        leftturnImage = new Texture("leftTurn.jpg");
        rightturnImage = new Texture("rightTurn.jpg");
        whitebarImage = new Texture("whiteBar.jpg");
        turnImage = new Texture("turn.jpg");
        nowImage = new Texture("now.jpg");
        taskImage = new Texture("task.jpg");
    }
	
	public void render () {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		renderBackground();
		renderTurnBar();
		renderTurnNumber();
		renderTask();
		renderNow();
		batch.end();
    }
	
	public void renderBackground () {
		batch.draw(backgroundImage, 0, 0);
	}
	
	public void renderTurnBar () {
		if (world.turn%2==0) {
			batch.draw(leftturnImage, 0, 628);
			batch.draw(whitebarImage, 600, 628);
		}
		else {
			batch.draw(whitebarImage, 0, 628);
			batch.draw(rightturnImage, 600, 628);
		}
	}
	
	public void renderTurnNumber () {
        batch.draw(turnImage, 500, 740);
		if(world.showTurn == 10) {
        	turnNumber = new Texture(imageName[1]);
        	batch.draw(turnNumber, 543, 680);
        	turnNumber = new Texture(imageName[0]);
        	batch.draw(turnNumber, 598, 680);
        }
        else {
        	turnNumber = new Texture(imageName[world.showTurn%10]);
        	batch.draw(turnNumber, 570, 680);
        }
	}
	
	public void renderNow () {
		batch.draw(nowImage, 60, 710);
		taskNumber = new Texture(imageName[world.current/10]);
    	batch.draw(taskNumber, 235, 710);
    	taskNumber = new Texture(imageName[world.current%10]);
    	batch.draw(taskNumber, 280, 710);
	}
	
	public void renderTask () {
//		System.out.println(world.task);
		batch.draw(taskImage, 950, 710);
		taskNumber = new Texture(imageName[world.task/10]);
    	batch.draw(taskNumber, 850, 710);
    	taskNumber = new Texture(imageName[world.task%10]);
    	batch.draw(taskNumber, 895, 710);
	}
}
