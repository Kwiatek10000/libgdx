package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture car;
	Texture map;
	Texture grid;
	OrthographicCamera mapCamera;
	OrthographicCamera carCamera;
	float time = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		car = new Texture("Audi.png");
		map = new Texture("mapa.png");
		grid = new Texture("libgdxgridtest.png");
		mapCamera = new OrthographicCamera();
		carCamera = new OrthographicCamera();
	}

	@Override
	public void render () {
		time += Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		carCamera.setToOrtho(false, 800, 400);
		//carCamera.translate(-800/2, -400/2);
		carCamera.translate(25, 100);
		//carCamera.rotate(time*10);
		carCamera.zoom = 0.5f;
		carCamera.update();

		mapCamera.setToOrtho(false, 800, 400);
		//mapCamera.translate(-800/2, -400/2);
		mapCamera.translate(0, time*64);
		mapCamera.update();

		batch.begin();
		{
			batch.setProjectionMatrix(mapCamera.combined);
			batch.draw(map, 0, 0);
			batch.setProjectionMatrix(carCamera.combined);
			batch.draw(car, 200, 200);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}