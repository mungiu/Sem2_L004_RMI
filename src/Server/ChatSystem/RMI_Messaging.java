package Server.ChatSystem;

import Shared.ChatSystem.IClientRemoteCall;
import Shared.ChatSystem.IMessaging;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Messaging implements IMessaging
{
	/**
	 * NOTE: This database is instantiated and server start and deleted at server closing
	 * technically this is where the Real database should somewhere connect
	 */
	private ConnectedClientsDatabase db;

	public RMI_Messaging() throws RemoteException
	{
		db = new ConnectedClientsDatabase();
		UnicastRemoteObject.exportObject(this, 0);
	}

	@Override
	public void registerClient(IClientRemoteCall iClientRemoteCall, String name)
	{
		if (!db.getClientMap().containsKey(name))
			db.addClientToMap(name, iClientRemoteCall);
	}

	@Override
	public void broadcastToAll(String theOriginalMessage,
							   IClientRemoteCall iClientRemoteCall,
							   String clientID) throws RemoteException
	{
		db.addMessage(theOriginalMessage);
		for (String s : db.getClientMap().keySet())
		{
			IClientRemoteCall temp = db.getClientMap().get(s);
			temp.sendMessageToClient
					(clientID + " : " + theOriginalMessage);
		}
	}
}
