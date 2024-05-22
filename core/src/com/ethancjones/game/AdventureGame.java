package com.ethancjones.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ethancjones.game.states.MenuState;
import com.ethancjones.game.states.State;

public class AdventureGame extends ApplicationAdapter
{
	private SpriteBatch batch;
	private State currentState;
	private final State menuState = new MenuState();

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		menuState.create();
		currentState = menuState;
	}

	@Override
	public void render()
	{
		ScreenUtils.clear(1, 1, 1, 1);
		currentState.update(Gdx.graphics.getDeltaTime());
		batch.begin();
		currentState.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
		currentState.dispose();
	}
}
