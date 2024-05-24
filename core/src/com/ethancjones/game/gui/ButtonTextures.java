package com.ethancjones.game.gui;

import com.badlogic.gdx.graphics.Texture;

/*
Used to create every button texture used in the UI

Saves memory
 */
public class ButtonTextures
{
    public static Texture BUTTON_LARGE_HOVER;
    public static Texture BUTTON_SMALL_HOVER;
    public static Texture BUTTON_COG_HOVER;
    public static Texture BUTTON_LARGE_PRESSED;
    public static Texture BUTTON_SMALL_PRESSED;
    public static Texture BUTTON_COG_PRESSED;
    public static Texture BUTTON_LARGE;
    public static Texture BUTTON_SMALL;
    public static Texture BUTTON_COG;

    public static void createTextures()
    {
        BUTTON_LARGE_HOVER = new Texture("buttons/hover large.png");
        BUTTON_SMALL_HOVER = new Texture("buttons/hover small.png");
        BUTTON_COG_HOVER = new Texture("buttons/hover small cog.png");
        BUTTON_LARGE_PRESSED = new Texture("buttons/pressed large.png");
        BUTTON_SMALL_PRESSED = new Texture("buttons/pressed small.png");
        BUTTON_COG_PRESSED = new Texture("buttons/pressed small cog.png");
        BUTTON_LARGE = new Texture("buttons/unpressed large.png");
        BUTTON_SMALL = new Texture("buttons/unpressed small.png");
        BUTTON_COG = new Texture("buttons/unpressed small cog.png");
    }
}
