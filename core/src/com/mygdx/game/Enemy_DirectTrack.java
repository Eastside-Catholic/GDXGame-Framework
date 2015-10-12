package com.mygdx.game;

public class Enemy_DirectTrack extends Enemy {

	public Enemy_DirectTrack(int spriteID) {
		super(spriteID);
	}
	
	@Override
	public void tick(int tickcount)
	{
		super.tick(tickcount);
		if (tickcount%2==0)
			return;
		Actor target=ActorManager.getNearestInput(this);
		if (target==null)
			return;
		if (this.x<target.x)
		{
			this.x++;
		}
		if (this.x>target.x)
		{
			this.x--;
		}
		if (this.y<target.y)
		{
			this.y++;
		}
		if (this.y>target.y)
		{
			this.y--;
		}
	}

}
