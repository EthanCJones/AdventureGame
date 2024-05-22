package com.ethancjones.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class AdventureGame extends ApplicationAdapter
{
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		img = new Texture("background/layer1.png");
	}

	@Override
	public void render ()
	{
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		img.dispose();
	}
}