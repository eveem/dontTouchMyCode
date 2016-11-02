package com.monpriya.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter {
	
	ProjectGame game;
	private Texture mainMenuImage;
	private SpriteBatch batch;
	
	OrthographicCamera guiCam;
	Rectangle playBounds;
	Rectangle howtoBounds;
	Rectangle exitBounds;
	Vector3 touchPoint;
	
	MainMenuScreen (ProjectGame projectGame) {
		this.game = projectGame;
		mainMenuImage = new Texture("openScreen.jpg");
		batch = new SpriteBatch(); 
		
		guiCam = new OrthographicCamera(800, 800);
		guiCam.position.set(800 / 2, 800 / 2, 0);
		playBounds = new Rectangle(-102, -95, 222, 55);
		howtoBounds = new Rectangle(-140, 180, 290, 55);
		exitBounds = new Rectangle(-40, -265, 95, 55);
		touchPoint = new Vector3();
	}
	
	public void update () {
		if (Gdx.input.justTouched()) {
			guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			System.out.println(touchPoint.x);
			System.out.println(touchPoint.y);
			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				game.setScreen(new GameScreen());
				return;
			}
//			if (howtoBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HighscoresScreen(game));
//				return;
//			}
			if (exitBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
				Gdx.app.exit();
			}
		}
	}
	
	public void draw () {
		batch.begin();
		batch.draw(mainMenuImage, 0, 0);
		batch.end();
	}
	
	@Override
	public void render (float delta) {
		 update();
		draw();
	}
	
}
