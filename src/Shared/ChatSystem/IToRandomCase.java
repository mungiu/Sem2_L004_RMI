package Shared.ChatSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IToRandomCase extends Remote
{
	/**
	 * Transforms the string into the same with random upper case letter
	 *
	 * @param theOriginalMessage message from the client
	 * @param iClientRemoteCall  the client instance for remote acccess
	 * @return the resultant string
	 * @throws RemoteException
	 */
	String toRandomCase(String theOriginalMessage, IClientRemoteCall iClientRemoteCall) throws RemoteException;

	/**
	 * Returns the current instance of the randomizer
	 *
	 * @return the current randomizer instance
	 * @throws RemoteException
	 */
	IToRandomCase getRandomizer() throws RemoteException;
}
