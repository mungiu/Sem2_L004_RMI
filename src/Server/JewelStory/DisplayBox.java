package Server.JewelStory;

import Shared.JewelStory.TheJewel;

import java.util.ArrayList;

public class DisplayBox
{
	ArrayList<TheJewel> jewelsOnDisplay;
	Safe safe;

	public DisplayBox()
	{
		jewelsOnDisplay = new ArrayList<>();
		safe = new Safe();
	}

	/**
	 * Checks is jewel is already displayed
	 *
	 * @param theJewel
	 * @return
	 */
	public boolean jewelIsOnDisplay(TheJewel theJewel)
	{
		if (jewelsOnDisplay.contains(theJewel))
			return true;
		else
			return false;
	}

	/**
	 * Removes jewel from Safe and adds it to DisplayBox
	 *
	 * @param theJewel
	 */
	public void addJewelToDisplayBox(TheJewel theJewel)
	{
		// checking if jewel already displayed
		if (!jewelIsOnDisplay(theJewel))
		{
			safe.takeJewelOutFromSafe(theJewel);
			jewelsOnDisplay.add(theJewel);
		}
	}

	/**
	 * Remove jewel from DisplayBox and adds it back to the safe
	 *
	 * @param theJewel
	 */
	public void putJewelBackInSafe(TheJewel theJewel)
	{
		// checking if jewel is really displayed first
		if (jewelIsOnDisplay(theJewel))
		{
			jewelsOnDisplay.remove(theJewel);
			safe.addJewelToSafe(theJewel);
		}
	}

	public void removeJewelFromDisplayBox(TheJewel theJewel)
	{
		// checking if the jewel is really on Display
		if (jewelIsOnDisplay(theJewel))
			jewelsOnDisplay.remove(theJewel);
	}
}
