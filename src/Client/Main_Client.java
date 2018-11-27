package Client;

import Client.ChatSystem.RMI_RemoteMessageClient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// TODO Understand the security manager and how to use RMI
// TODO ask Troels, is this a correct structure?
public class Main_Client
{
	public static void main(String[] args)
	{
		System.setProperty("java.security.policy", "file:./security.policy");
//		if (System.getSecurityManager() == null)
//			System.setSecurityManager(new RMISecurityManager());
		// TODO ask Troels what you should do if the below is deprecated:P
		RMI_RemoteMessageClient remoteMessageClient;

		try
		{
			remoteMessageClient = new RMI_RemoteMessageClient();
			remoteMessageClient.run();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		System.out.println("Client_RestrictedAccess started...");
	}
}
