package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class SpriteManager {
	static ArrayList<Texture> sprites = new ArrayList<Texture>();
	
	/** 
	 * Returns the texture matching a sprite ID.
	 * If the ID has not been loaded, loads it,
	 * Otherwise, returns cached value.
	 * 
	 * @param i Sprite ID
	 * @return Sprite texture
	 */
	public static Texture get(int i)
	{
		Texture sprite;
		if (sprites.size()<=i)
		{
			sprite = new Texture(Constants.spritefiles[i]);
			sprites.add(i, sprite);
		}
		else if (sprites.get(i)==null)
		{
			sprite = new Texture(Constants.spritefiles[i]);
			sprites.set(i, sprite);
		}
		else
		{
			sprite = sprites.get(i);
		}
		return sprite;
	}
}
	