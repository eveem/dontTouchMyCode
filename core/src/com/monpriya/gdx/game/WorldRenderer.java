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
	private SpriteBatch batch;
	private World world;
	
	public WorldRenderer (ProjectGame game, World world) {
		batch = game.batch;
        backgroundImage = new Texture("playScreen.jpg");
        leftturnImage = new Texture("leftTurn.jpg");
        rightturnImage = new Texture("rightTurn.jpg");
        whitebarImage = new Texture("whiteBar.jpg");
        this.world = world;
    }
	
	public void render () {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderBackground();
		renderTurn();
    }
	
	public void renderBackground () {
		batch.disableBlending();
		batch.begin();
		batch.draw(backgroundImage, 0, 0);
		batch.end();
	}
	
	public void renderTurn () {
		batch.begin();
		if (world.turn%2==0) {
			batch.draw(leftturnImage, 0, 628);
			batch.draw(whitebarImage, 600, 628);
		}
		else {
			batch.draw(whitebarImage, 0, 628);
			batch.draw(rightturnImage, 600, 628);
		}
		batch.end();
	}
	
}
