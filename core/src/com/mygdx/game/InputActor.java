package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputActor extends Actor {
	
	int LEFTKEY=Input.Keys.LEFT;
	int RIGHTKEY=Input.Keys.RIGHT;
	int UPKEY=Input.Keys.UP;
	int DOWNKEY=Input.Keys.DOWN;
	int AKEY=Input.Keys.SPACE;
	int BKEY=Input.Keys.SHIFT_RIGHT;
	int XKEY=Input.Keys.SHIFT_LEFT;
	int YKEY=Input.Keys.TAB;
	
	public InputActor(int spriteID)
	{
		super(spriteID);
	}
	
	@Override
	public void tick(int tickcount)
	{
		super.tick(tickcount);
		int keyspressed=0;
		int keysjustpressed=0;
		if (Gdx.input.isKeyPressed(this.UPKEY))
			keyspressed|=0b00000001;
		if (Gdx.input.isKeyPressed(this.DOWNKEY))
			keyspressed|=0b00000010;
		if (Gdx.input.isKeyPressed(this.LEFTKEY))
			keyspressed|=0b00000100;
		if (Gdx.input.isKeyPressed(this.RIGHTKEY))
			keyspressed|=0b00001000;
		if (Gdx.input.isKeyPressed(this.AKEY))
			keyspressed|=0b00010000;
		if (Gdx.input.isKeyPressed(this.BKEY))
			keyspressed|=0b00100000;
		if (Gdx.input.isKeyPressed(this.XKEY))
			keyspressed|=0b01000000;
		if (Gdx.input.isKeyPressed(this.YKEY))
			keyspressed|=0b10000000;
		
		if (Gdx.input.isKeyJustPressed(this.UPKEY))
			keysjustpressed|=0b00000001;
		if (Gdx.input.isKeyJustPressed(this.DOWNKEY))
			keysjustpressed|=0b00000010;
		if (Gdx.input.isKeyJustPressed(this.LEFTKEY))
			keysjustpressed|=0b00000100;
		if (Gdx.input.isKeyJustPressed(this.RIGHTKEY))
			keysjustpressed|=0b00001000;
		if (Gdx.input.isKeyJustPressed(this.AKEY))
			keysjustpressed|=0b00010000;
		if (Gdx.input.isKeyJustPressed(this.BKEY))
			keysjustpressed|=0b00100000;
		if (Gdx.input.isKeyJustPressed(this.XKEY))
			keysjustpressed|=0b01000000;
		if (Gdx.input.isKeyJustPressed(this.YKEY))
			keysjustpressed|=0b10000000;
		
		this.processInput(keyspressed,keysjustpressed);
	}

	public void processInput(int keyspressed, int keysjustpressed) {
		// TODO Auto-generated method stub
		
	}
}
