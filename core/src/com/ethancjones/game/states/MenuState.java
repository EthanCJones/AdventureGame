package com.ethancjones.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ethancjones.game.AdventureGame;
import com.ethancjones.game.gui.Button;

/*
The main menu of the game
 */
public class MenuState extends State
{
    private boolean firstRun = true;
    private Texture sunLayer;
    private Texture grassLayer;
    private Texture peopleLayer;
    private float grassY;
    private float peopleAlpha;

    private Button playButton;

    @Override
    public void create()
    {
        playButton = new Button(1280.0F / 2 - 250, 300, Button.ButtonType.LARGE, () -> AdventureGame.changeState(AdventureGame.gameState));
        sunLayer = new Texture("background/layer1.png");
        grassLayer = new Texture("background/layer2.png");
        peopleLayer = new Texture("background/layer3.png");
        grassY = -grassLayer.getHeight() * 0.7F;
    }

    @Override
    public void update(float delta)
    {
        if (firstRun)
        {
            firstLaunch(delta);
        }

        playButton.update();
    }

    @Override
    public void render(SpriteBatch batch)
    {
        batch.draw(sunLayer, 0, 0);
        batch.draw(grassLayer, 0, grassY);
        batch.setColor(1, 1, 1, peopleAlpha);
        batch.draw(peopleLayer, 0, 0);
        batch.setColor(1, 1, 1, 1);

        if (!firstRun)
        {
            playButton.render(batch);
        }
    }

    @Override
    public void dispose()
    {
        sunLayer.dispose();
        grassLayer.dispose();
        peopleLayer.dispose();
    }

    //Used for the menu animation on a first launch
    private void firstLaunch(float delta)
    {
        if (grassY < 0)
        {
            grassY += (720 * 0.4F) * delta;
        }
        else if (grassY > 0)
        {
            grassY = 0;
        }
        else if (peopleAlpha < 1)
        {
            peopleAlpha += 0.5F * delta;
        }
        else if (peopleAlpha > 1)
        {
            peopleAlpha = 1;
        }
        else
        {
            firstRun = false;
        }
    }
}
