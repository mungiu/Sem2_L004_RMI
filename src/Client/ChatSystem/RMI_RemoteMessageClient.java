package Client.ChatSystem;

import Shared.ChatSystem.IClientRemoteCall;
import Shared.ChatSystem.IMessaging;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

// TODO Understand the security manager and how to use RMI

/**
 * Remote Message Client_RestrictedAccess
 */
public class RMI_RemoteMessageClient implements IClientRemoteCall, Runnable
{
	private Scanner keyboard;
	private IMessaging iMessaging;

	private String theOriginalMessage = null;
	private String clientID;

	public RMI_RemoteMessageClient() throws RemoteException, NotBoundException, MalformedURLException
	{
		keyboard = new Scanner(System.in);
		System.out.println("Input Nickname: ");
		clientID = keyboard.nextLine();

		UnicastRemoteObject.exportObject(this, 0);

		// "rmi://<ip>:<port>/<serverName>
		iMessaging = (IMessaging) Naming.lookup
				("rmi://localhost:1099/remoteMessageServer");
	}

	@Override
	public void sendMessageToClient(String serverMessage)
	{
		System.out.println(serverMessage + "\n");
	}

	@Override
	public void run()
	{
		keyboard = new Scanner(System.in);

		while (true)
		{
			try
			{
				iMessaging.registerClient(this, clientID);
				theOriginalMessage = keyboard.nextLine();
				iMessaging.broadcastToAll(theOriginalMessage, this, clientID);
			}
			catch (RemoteException e)
			{
				e.printStackTrace();
			}
		}
	}
}
