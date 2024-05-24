package com.ethancjones.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*
Used to create any buttons in the UI
 */
public class Button
{
    private final float x;
    private final float y;
    private final int width;
    private final int height;
    private final ButtonType type;
    private ButtonState state = ButtonState.UNPRESSED;
    private final Runnable runnable;

    public Button(float initX, float initY, ButtonType initType, Runnable initRunnable)
    {
        x = initX;
        y = initY;
        type = initType;
        width = type.getTexture(state).getWidth();
        height = type.getTexture(state).getHeight();
        runnable = initRunnable;
    }

    public void update()
    {
        if (Gdx.input.getX() > x && Gdx.input.getX() < x + width && Gdx.input.getY() > y && Gdx.input.getY() < y + height)
        {
            switch (state)
            {
                case UNPRESSED:
                    hover();
                    break;
                case HOVER:
                    if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
                    {
                        click();
                    }
                    break;
                case PRESSED:
                    if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT))
                    {
                        release();
                    }
                    break;
            }
        }
        else
        {
            state = ButtonState.UNPRESSED;
        }
    }

    private void hover()
    {
        state = ButtonState.HOVER;
    }

    private void click()
    {
        state = ButtonState.PRESSED;
    }

    private void release()
    {
        state = ButtonState.UNPRESSED;
        runnable.run();
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(type.getTexture(state), x , y);
    }

    public enum ButtonType
    {
        LARGE(ButtonTextures.BUTTON_LARGE, ButtonTextures.BUTTON_LARGE_PRESSED, ButtonTextures.BUTTON_LARGE_HOVER),
        SMALL(ButtonTextures.BUTTON_SMALL, ButtonTextures.BUTTON_SMALL_PRESSED, ButtonTextures.BUTTON_SMALL_HOVER),
        COG(ButtonTextures.BUTTON_COG, ButtonTextures.BUTTON_COG_PRESSED, ButtonTextures.BUTTON_COG_HOVER);

        final Texture UNPRESSED;
        final Texture PRESSED;
        final Texture HOVER;

        ButtonType(Texture UNPRESSED, Texture PRESSED, Texture HOVER)
        {
            this.UNPRESSED = UNPRESSED;
            this.PRESSED = PRESSED;
            this.HOVER = HOVER;
        }

        public Texture getTexture(ButtonState state)
        {
            switch (state)
            {
                case UNPRESSED:
                    return UNPRESSED;
                case PRESSED:
                    return PRESSED;
                case HOVER:
                    return HOVER;
            }

            System.out.println("Could not find button texture");
            return null;
        }
    }

    private enum ButtonState
    {
        UNPRESSED,
        PRESSED,
        HOVER
    }
}
