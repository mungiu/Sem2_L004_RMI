package Server.JewelStory;

import Shared.JewelStory.ISalesMan;
import Shared.JewelStory.TheJewel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI_SalesMan implements ISalesMan
{
	Safe safe;
	DisplayBox displayBox;
	TheJewel jewelOnHands;

	public RMI_SalesMan() throws RemoteException
	{
		UnicastRemoteObject.exportObject(this, 0);
	}

	@Override
	public void showJewel(TheJewel theJewel) throws RemoteException
	{
		if (jewelOnHands == null & displayBox.jewelIsOnDisplay(theJewel))
		{
			displayBox.removeJewelFromDisplayBox(theJewel);
			jewelOnHands = theJewel;
			System.out.println("Showing jewel from hands");
		}
		else if (jewelOnHands == null & safe.jewelIsInSafe(theJewel))
		{
			safe.takeJewelOutFromSafe(theJewel);
			jewelOnHands = theJewel;
			System.out.println("Showing jewel from hands");
		}
		else if (jewelOnHands != null)
			System.out.println("Hands are busy with another jewel");
		else if (!displayBox.jewelIsOnDisplay(theJewel) & !safe.jewelIsInSafe(theJewel))
			System.out.println("Jewel currently unavailable, come back later");
	}

	@Override
	public void putJewelBackToDisplayBox() throws RemoteException
	{
		if (jewelOnHands != null)
		{
			displayBox.addJewelToDisplayBox(jewelOnHands);
			jewelOnHands = null;
		}
	}

	@Override
	public void putAllJewelsBackToSafe() throws RemoteException
	{
		if (jewelOnHands != null)
		{
			safe.addJewelToSafe(jewelOnHands);
			jewelOnHands = null;
		}
		for (TheJewel theJewel :
				displayBox.jewelsOnDisplay)
		{
			displayBox.removeJewelFromDisplayBox(theJewel);
			safe.addJewelToSafe(theJewel);
		}
	}

	@Override
	public void sellJewel() throws RemoteException
	{
		jewelOnHands = null;
	}
}
