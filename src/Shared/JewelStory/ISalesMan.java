package Shared.JewelStory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ISalesMan extends Remote
{
	ArrayList<TheJewel> jewelsInMemory = null;

	/**
	 * Shows a jewel to the customer
	 *
	 * @param theJewel
	 * @return
	 * @throws RemoteException
	 */
	void showJewel(TheJewel theJewel) throws RemoteException;

	/**
	 * Places a jewel back in the safe
	 *
	 * @throws RemoteException
	 */
	void putJewelBackToDisplayBox() throws RemoteException;

	void putAllJewelsBackToSafe() throws RemoteException;

	void sellJewel() throws RemoteException;
}
