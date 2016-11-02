package com.monpriya.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldrenderer;
	
	public GameScreen (ProjectGame game) {
		this.game = game;
		world = new World();
		worldrenderer = new WorldRenderer(game, world);
	}
	
	@Override
	public void render (float delta) {
//		update();
		draw();
	}
	
	public void draw () {
		worldrenderer.render();
	}
}
