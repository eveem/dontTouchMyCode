package com.monpriya.gdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldRenderer;
	
	public GameScreen (ProjectGame game) {
		this.game = game;
		world = new World(game);
		worldRenderer = new WorldRenderer(game, world);
	}
	
	@Override
	public void render (float delta) {
		world.update();
		draw();
	}
	
	public void draw () {
		worldRenderer.render();
	}
}
