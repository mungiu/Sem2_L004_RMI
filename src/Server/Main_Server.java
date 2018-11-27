package Server;

import Server.ChatSystem.RMI_Messaging;
import Server.JewelStory.RMI_SalesMan;
import Shared.ChatSystem.IMessaging;
import Shared.JewelStory.ISalesMan;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// TODO Understand the security manager and how to use RMI
public class Main_Server
{
	public static void main(String[] args)
	{
		// here we are crating one RMI for each performed action
		try
		{
			// Creates and exports a registry instance on the local host
			// that accepts requests on the specified port
			LocateRegistry.createRegistry(1099);
			// Instantiating interfaces to act as remote method invokers
			IMessaging remoteMessageServer = new RMI_Messaging();
			ISalesMan salesMan = new RMI_SalesMan();
			//  Placing the server into the registry with new names
			Naming.rebind("remoteMessageServer", remoteMessageServer);
			Naming.rebind("salesMan", salesMan);
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Server started...");
	}
}
