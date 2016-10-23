package com.monpriya.gdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen extends ScreenAdapter {
	
	ProjectGame game;
	private Texture mainMenuImage;
	private SpriteBatch batch;
	
	MainMenuScreen (ProjectGame projectGame) {
		this.game = projectGame;
		mainMenuImage = new Texture("openScreen.jpg");
		batch = new SpriteBatch(); 
	}
	
	/*public void update () {
		
	}*/
	
	public void draw () {
		batch.begin();
		batch.draw(mainMenuImage, 0, 0);
		batch.end();
	}
	
	@Override
	public void render (float delta) {
		// update();
		draw();
	}
	
}
