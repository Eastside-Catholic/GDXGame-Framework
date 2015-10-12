package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Actor {
	public int spriteID;
	public int actorID;
	public float x;
	public float y;
	public int width_tiles=1;
	public int height_tiles=1;
	public boolean active=false;
	public int health;
	public Actor(int spriteID)
	{
		this.spriteID=spriteID;
	}
	public void place(int x, int y)
	{
		this.x=x;
		this.y=y;
		this.active=true;
	}
	public void tick(int tickcount)
	{
		
	}
	public void render(SpriteBatch batch)
	{
		if (!active)
		{
			return;
		}
		batch.draw(SpriteManager.get(this.spriteID),this.x,this.y,Constants.TILE_WIDTH*this.width_tiles,Constants.TILE_HEIGHT*this.height_tiles);
	}
	public void kill()
	{
		this.active=false;
		ActorManager.delete(this.actorID);
	}
	public void damage(int damage)
	{
		this.health-=damage;
		if (this.health<=0)
			this.kill();
	}
	public boolean collide(Actor actor)
	{
		return Intersector.overlaps(new Rectangle(this.x,this.y,Constants.TILE_WIDTH*this.width_tiles,Constants.TILE_HEIGHT*this.width_tiles),new Rectangle(actor.x,actor.y,Constants.TILE_WIDTH*actor.width_tiles,Constants.TILE_HEIGHT*actor.height_tiles));
	}
}
