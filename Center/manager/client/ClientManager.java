package client;

import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;


public class ClientManager {
	public ConcurrentHashMap<Channel, Client> onlineClients=new ConcurrentHashMap<>();
	public ConcurrentHashMap<Channel, Client> leavingClients=new ConcurrentHashMap<>();
	
	private static ClientManager clientManager=null;
	private ClientManager() {
		
	}
	
	public static ClientManager getInstance() {
		if(clientManager==null) {
			clientManager=new ClientManager();
		}
		return clientManager;
	}
	
	public void init() {
		
	}
}
