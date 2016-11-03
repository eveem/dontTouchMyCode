package com.monpriya.gdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldrenderer;
	
	public GameScreen (ProjectGame game) {
		this.game = game;
		world = new World(game);
		worldrenderer = new WorldRenderer(game, world);
	}
	
	@Override
	public void render (float delta) {
		world.update();
		draw();
	}
	
	public void draw () {
		worldrenderer.render();
	}
}
