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
	Rectangle soundBounds;
	Rectangle playBounds;
	Rectangle highscoresBounds;
	Rectangle helpBounds;
	Vector3 touchPoint;
	
	MainMenuScreen (ProjectGame projectGame) {
		this.game = projectGame;
		mainMenuImage = new Texture("openScreen.jpg");
		batch = new SpriteBatch(); 
		
		guiCam = new OrthographicCamera(800, 800);
		guiCam.position.set(800 / 2, 800 / 2, 0);
//		soundBounds = new Rectangle(0, 0, 64, 64);
		playBounds = new Rectangle(-102, -95, 222, 55);
//		playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
//		highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
//		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
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
//			if (highscoresBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HighscoresScreen(game));
//				return;
//			}
//			if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				game.setScreen(new HelpScreen(game));
//				return;
//			}
//			if (soundBounds.contains(touchPoint.x, touchPoint.y)) {
//				Assets.playSound(Assets.clickSound);
//				Settings.soundEnabled = !Settings.soundEnabled;
//				if (Settings.soundEnabled)
//					Assets.music.play();
//				else
//					Assets.music.pause();
//			}
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
