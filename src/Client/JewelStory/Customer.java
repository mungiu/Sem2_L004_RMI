package Client.JewelStory;

import Shared.JewelStory.ISalesMan;
import Shared.JewelStory.TheJewel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Customer
{
	private ArrayList<TheJewel> jewelsOfInterest;
	private ISalesMan iSalesMan;

	public Customer() throws RemoteException, NotBoundException, MalformedURLException
	{
		// "rmi://<ip>:<port>/<serverName>
		iSalesMan = (ISalesMan) Naming.lookup("rmi://localhost:1099/salesMan");

		jewelsOfInterest = new ArrayList<TheJewel>()
		{{
			add(new TheJewel("J1", 1));
			add(new TheJewel("J2", 1));
			add(new TheJewel("J3", 1));
			add(new TheJewel("J4", 1));
		}};
	}

	public void askToSeeRandomJewel()
	{
		int temp = (int) Math.floor((Math.random() * 39));

		try
		{
			iSalesMan.showJewel(jewelsOfInterest.get(temp));
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}

	public void expressDislike()
	{
		try
		{
			iSalesMan.putJewelBackToDisplayBox();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}

	public void buyJewel()
	{
		try
		{
			iSalesMan.sellJewel();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
	}
}
