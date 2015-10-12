package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class InputActor_Steering extends InputActor {
	float angle=0f;
	public InputActor_Steering(int spriteID) {
		super(spriteID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void processInput(int keyspressed, int keysjustpressed) {
		if ((keyspressed&0b00001000)!=0)
			this.angle-=1.0f;
		if ((keyspressed&0b00000100)!=0)
			this.angle+=1.0f;
		if ((keyspressed&0b00000010)!=0)
		{
			this.x+=Math.sin(Math.toRadians(this.angle))*2f;
			this.y-=Math.cos(Math.toRadians(this.angle))*2f;
		}
		if ((keyspressed&0b00000001)!=0)
		{
			this.x-=Math.sin(Math.toRadians(this.angle))*2f;
			this.y+=Math.cos(Math.toRadians(this.angle))*2f;
		}
		
	}
	@Override
	public void render(SpriteBatch batch) {
		if (!active)
		{
			return;
		}
		TextureRegion sp = new TextureRegion(SpriteManager.get(this.spriteID),0,0,32,32);
		batch.draw(sp, (float)this.x, (float)this.y, sp.getRegionWidth()/2f, sp.getRegionHeight()/2f, (float)sp.getRegionWidth(), (float)sp.getRegionHeight(), 1f, 1f, this.angle);
	}
	
}
