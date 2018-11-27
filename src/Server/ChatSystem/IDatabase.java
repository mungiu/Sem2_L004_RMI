package Server.ChatSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDatabase extends Remote
{
	/**
	 * Adds a task to the task list
	 *
	 * @param task
	 */
	void addTask(String task) throws RemoteException;

	/**
	 * Adds a message to the message list
	 *
	 * @param message
	 */
	void addMessage(String message) throws RemoteException;

	/**
	 * Get an removes the next task from the taskList
	 *
	 * @return
	 */
	String getAndRemoveNextTask() throws RemoteException;

	/**
	 * Gets the taskList size
	 *
	 * @return
	 */
	int getTasksListSize() throws RemoteException;
}
