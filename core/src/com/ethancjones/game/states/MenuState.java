package com.ethancjones.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
The main menu of the game
 */
public class MenuState extends State
{
    private Texture sunLayer;
    private Texture grassLayer;
    private Texture peopleLayer;
    @Override
    public void create()
    {
        sunLayer = new Texture("background/layer1.png");
        grassLayer = new Texture("background/layer2.png");
        peopleLayer = new Texture("background/layer3.png");
    }

    @Override
    public void update(float delta)
    {
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(sunLayer, 0, 0);
        batch.draw(grassLayer, 0, 0);
        batch.draw(peopleLayer, 0, 0);
    }

    @Override
    public void dispose()
    {
        sunLayer.dispose();
        grassLayer.dispose();
        peopleLayer.dispose();
    }
}
