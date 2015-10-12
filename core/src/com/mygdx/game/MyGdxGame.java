package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int tickcount=0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		InputActor iac = new InputActor_XY(Constants.SPRITE_GDX);
		iac.UPKEY=Input.Keys.W;
		iac.LEFTKEY=Input.Keys.A;
		iac.DOWNKEY=Input.Keys.S;
		iac.RIGHTKEY=Input.Keys.D;
		iac.place(16, 16);
		ActorManager.addInput(iac);
		iac = new InputActor_XY(Constants.SPRITE_GDX);
		iac.UPKEY=Input.Keys.I;
		iac.LEFTKEY=Input.Keys.J;
		iac.DOWNKEY=Input.Keys.K;
		iac.RIGHTKEY=Input.Keys.L;
		iac.place(16, 16);
		ActorManager.addInput(iac);
		Actor ac = new Enemy_DirectTrack(Constants.SPRITE_GDX);
		ac.place(192,192);
		ActorManager.add(ac);
	}

	@Override
	public void render () {
		tickcount++;
		ActorManager.tick(tickcount);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		ActorManager.render(batch);
		batch.end();
	}
}
