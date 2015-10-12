package com.mygdx.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utilities {

	public static Object selectRandomNotNull(ArrayList list) {
		Integer[] randomarr = new Integer[list.size()];
		for (int i=0;i<list.size();i++)
		{
			randomarr[i]=i;
		}
		List<Integer> randomlist=Arrays.asList(randomarr);
		Collections.shuffle(randomlist);
		for (int i=0; i<list.size(); i++)
		{
			Object item=list.get(randomlist.get(i));
			if (item!=null)
				return item;
		}
		return null;
	}

	public static double distance(Actor a, Actor b) {
		return Math.sqrt(Math.pow(a.x-b.x, 2.0)+Math.pow(a.y-b.y, 2.0));
	}

}
