package com.monpriya.gdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldrenderer;
	int answer;
	
	public GameScreen (ProjectGame game) {
		this.game = game;
		world = new World();
		worldrenderer = new WorldRenderer(game, world);
		answer = 0;
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
