package com.ethancjones.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ethancjones.game.gui.ButtonTextures;
import com.ethancjones.game.states.GameState;
import com.ethancjones.game.states.MenuState;
import com.ethancjones.game.states.State;

public class AdventureGame extends ApplicationAdapter
{
	private SpriteBatch batch;
	private static State currentState;
	public static final State menuState = new MenuState();
	public static final State gameState = new GameState();

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		ButtonTextures.createTextures();

		menuState.create();
		gameState.create();

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

	public static State getCurrentState()
	{
		return currentState;
	}

	public static void changeState(State newState)
	{
		currentState = newState;
	}
}
