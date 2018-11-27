package Shared.ChatSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientRemoteCall extends Remote
{
	/**
	 * Print out a message on the client
	 *
	 * @param serverMessage the received message from the server
	 */
	void sendMessageToClient(String serverMessage) throws RemoteException;
}

