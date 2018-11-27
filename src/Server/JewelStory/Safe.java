package Server.JewelStory;

import Shared.JewelStory.TheJewel;

import java.util.ArrayList;

public class Safe
{
	private ArrayList<TheJewel> jewelArrayList;

	public Safe()
	{
		jewelArrayList = new ArrayList<TheJewel>()
		{{
			add(new TheJewel("J1", 1));
			add(new TheJewel("J2", 2));
			add(new TheJewel("J3", 3));
			add(new TheJewel("J4", 4));
			add(new TheJewel("J5", 5));
			add(new TheJewel("J6", 6));
			add(new TheJewel("J7", 7));
			add(new TheJewel("J8", 8));
			add(new TheJewel("J9", 9));
			add(new TheJewel("J10", 10));
		}};
	}

	/**
	 * Places a jewel inside the safe
	 *
	 * @param theJewel
	 */
	public void addJewelToSafe(TheJewel theJewel)
	{
		jewelArrayList.add(theJewel);
	}

	/**
	 * Take an available jewel out from the safe
	 *
	 * @param theJewel
	 */
	public void takeJewelOutFromSafe(TheJewel theJewel)
	{
		if (jewelIsInSafe(theJewel))
			jewelArrayList.remove(theJewel);
	}

	/**
	 * Checks if the safe contains teh jewel
	 *
	 * @param theJewel
	 * @return
	 */
	public boolean jewelIsInSafe(TheJewel theJewel)
	{
		if (jewelArrayList.contains(theJewel))
			return true;
		else
			return false;
	}
}
