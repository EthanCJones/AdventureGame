package com.ethancjones.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
A state is used to control in what state the game is currently in(menu, gameplay, etc)

Helpful for changing between states
 */
public abstract class State
{
    public abstract void create();
    public abstract void update(float delta);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
}
