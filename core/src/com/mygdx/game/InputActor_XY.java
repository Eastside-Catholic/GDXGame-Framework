package com.mygdx.game;

public class InputActor_XY extends InputActor {
	
	public InputActor_XY(int spriteID) {
		super(spriteID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void processInput(int keyspressed, int keysjustpressed) {
		if ((keyspressed&0b00001000)!=0)
			this.x+=1;
		if ((keyspressed&0b00000100)!=0)
			this.x-=1;
		if ((keyspressed&0b00000010)!=0)
			this.y-=1;
		if ((keyspressed&0b00000001)!=0)
			this.y+=1;
		
	}
	
}
