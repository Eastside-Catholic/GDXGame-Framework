package com.mygdx.game;

public class Enemy extends Actor {

	public Enemy(int spriteID) {
		super(spriteID);
	}
	@Override
	public void tick(int tickcount)
	{
		super.tick(tickcount);
		for (Actor target : ActorManager.getInputs())
		{
			if (this.collide(target))
			{
				target.damage(1);
			}
		}
	}
}
