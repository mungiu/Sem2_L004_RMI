package Shared.ChatSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMessaging extends Remote
{
	/**
	 * Registers a client with its client ID
	 *
	 * @param iClientRemoteCall the client to be registered
	 * @param name              the name of the client
	 * @throws RemoteException
	 */
	void registerClient(IClientRemoteCall iClientRemoteCall, String name)
			throws RemoteException;

	/**
	 * Broadcasts the last client message to all clients
	 *
	 * @param theOriginalMessage message sent by client
	 * @throws RemoteException
	 */
	void broadcastToAll(String theOriginalMessage,
						IClientRemoteCall iClientRemoteCall,
						String clientID)
			throws RemoteException;
}
