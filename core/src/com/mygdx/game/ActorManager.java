package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ActorManager {
	static ArrayList<Actor> actors = new ArrayList<Actor>();
	static ArrayList<Integer> inputActors = new ArrayList<Integer>();
	/** 
	 * Adds an actor, returns 
	 * 
	 * @param a Actor
	 * @return Actor ID
	 */
	public static int addInput(InputActor a)
	{
		int aid=ActorManager.add(a);
		for (int i=0;i<inputActors.size();i++)
		{
			if (inputActors.get(i)==null)
			{
				inputActors.set(i, aid);
				a.actorID=aid;
				return i;
			}
		}
		inputActors.add(aid);
		a.actorID=aid;
		return actors.size()-1;
	}
	public static int add(Actor a)
	{
		for (int i=0;i<actors.size();i++)
		{
			if (actors.get(i)==null)
			{
				actors.set(i, a);
				a.actorID=i;
				return i;
			}
		}
		actors.add(a);
		a.actorID=actors.size()-1;
		return actors.size()-1;
	}
	
	/**
	 * Deletes an actor
	 * @param i Actor ID
	 */
	public static void delete(int i)
	{
		actors.set(i, null);
	}
	public static void deleteInput(int i)
	{
		ActorManager.delete(inputActors.get(i));
		inputActors.set(i, null);
	}
	
	
	/** 
	 * Returns the actor matching an actor ID.
	 * 
	 * @param i Actor ID
	 * @return Actor
	 */
	public static Actor get(int i)
	{
		return actors.get(i);
	}
	public static InputActor getInput(int i)
	{
		return (InputActor) actors.get(inputActors.get(i));
	}
	public static InputActor getNearestInput(Actor a)
	{
		double mindist=Double.MAX_VALUE;
		int minid=-1;
		for (int i=0; i<inputActors.size(); i++)
		{
			Actor item=actors.get(inputActors.get(i));
			if (item!=null)
			{
				if (Utilities.distance(item,a)<mindist)
				{
					mindist=Utilities.distance(item,a);
					minid=i;
				}
			}	
		}
		if (minid==-1)
			return null;
		return (InputActor) actors.get(inputActors.get(minid));
	}
	public static ArrayList<InputActor> getInputs() {
		ArrayList<InputActor> alist = new ArrayList<InputActor>();
		for (int i=0; i<inputActors.size(); i++)
		{
			Actor item=actors.get(inputActors.get(i));
			if (item!=null)
			{
				alist.add((InputActor) item);
			}	
		}
		return alist;
	}
	public static void tick(int tickcount)
	{
		for (Actor actor : actors)
		{
			if (actor!=null)
				actor.tick(tickcount);
		}
	}
	public static void render(SpriteBatch batch)
	{
		for (Actor actor : actors)
		{
			if (actor!=null)
				actor.render(batch);
		}
	}
}
	