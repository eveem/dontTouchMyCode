package com.monpriya.gdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen extends ScreenAdapter {
	
	ProjectGame game;
	World world;
	WorldRenderer worldrenderer;
	public static BitmapFont font;
	String answerString;
	
	public GameScreen (ProjectGame game) {
		this.game = game;
		world = new World(game);
		worldrenderer = new WorldRenderer(game, world);
        font = new BitmapFont();
        answerString = "TASK: " + world.answer;
	}
	
	@Override
	public void render (float delta) {
		world.update();
		draw();
	}
	
	public void draw () {
		worldrenderer.render();
		game.batch.begin();
		font.draw(game.batch, answerString, 100, 750);
		game.batch.end();
	}
}
