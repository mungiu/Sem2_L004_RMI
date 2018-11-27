package Server.ChatSystem;

import Shared.ChatSystem.IClientRemoteCall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConnectedClientsDatabase implements IDatabase
{
	private ArrayList<String> messageList;
	private ArrayList<String> tasksList;
	// active like a TKey TValue
	private Map<String, IClientRemoteCall> clientDictionary;

	public ConnectedClientsDatabase()
	{
		messageList = new ArrayList<>();
		tasksList = new ArrayList<>();
		clientDictionary = new HashMap<>();
	}

	public void addTask(String task)
	{
		tasksList.add(task);
	}

	public void addMessage(String message)
	{
		messageList.add(message);
	}

	public String getAndRemoveNextTask()
	{
		String nextTask = tasksList.get(0);
		tasksList.remove(0);
		return nextTask;
	}

	public int getTasksListSize()
	{
		return tasksList.size();
	}

	public void addClientToMap(String name, IClientRemoteCall iClientRemoteCall)
	{
		clientDictionary.put(name, iClientRemoteCall);
		System.out.println("Client_RestrictedAccess added");
	}

	public Map<String, IClientRemoteCall> getClientMap()
	{
		return clientDictionary;
	}
}
