package com.monpriya.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

	private Texture backgroundImage;
	private SpriteBatch batch;
	
	public WorldRenderer(ProjectGame game, World world) {
        batch = game.batch;
        backgroundImage = new Texture("playScreen.jpg");
    }
	
	public void render() {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderBackground();
    }
	
	public void renderBackground () {
		batch.disableBlending();
		batch.begin();
		batch.draw(backgroundImage, 0, 0);
		batch.end();
	}
	
}
