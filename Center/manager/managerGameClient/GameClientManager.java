package managerGameClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import common.Config;
import common.Out;
import io.netty.channel.Channel;
import managerWorld.CenterWorld;
import protoCenterGame.Register.BindMsgRequest;
import taskManager.TaskManager;


public class GameClientManager {
	private ConcurrentHashMap<Channel, GameClient> onlineClients=new ConcurrentHashMap<>();
	private ConcurrentHashMap<Channel, GameClient> leavingClients=new ConcurrentHashMap<>();
	

	
	
	
	private static GameClientManager clientManager=null;
	private GameClientManager() {
		
	}
	
	public static GameClientManager getInstance() {
		if(clientManager==null) {
			clientManager=new GameClientManager();
		}
		return clientManager;
	}
	
	public void init() {
		TaskManager.TaskExec.scheduleAtFixedRate(()->{
			leaveClients();
		}, 0L, Config.CenterGameNet.CenterServer.LeaveClientsIntval, TimeUnit.SECONDS);
		
	}
	
	public void broadcast(String route,byte[] content) {
		for (GameClient client : onlineClients.values()) {
			client.pushPacket(route, content);
		}
	}
	
	public void registerClient(GameClient gameClient) {
		if(!onlineClients.containsKey(gameClient.channel)){
			onlineClients.put(gameClient.channel, gameClient);
		}
	}
	
	public GameClient getOnlineClient(Channel channel) {
		return onlineClients.get(channel);
	}
	
	public void leavingClient(Channel channel) {
		GameClient gameClient = onlineClients.get(channel);
		if(gameClient==null) {
			Out.error("该用户不在线！");
		}
		gameClient.isOnline=false;
		
		if(!leavingClients.containsKey(channel)){
			leavingClients.put(channel, gameClient);
		}
	}
	
	public void leaveClients() {
		int count=0;
		for (GameClient gameClient : leavingClients.values()) {
			if(onlineClients.containsKey(gameClient.channel)) {
				onlineClients.remove(gameClient.channel);
//				gameClient.channel.close();
				count++;
			}
			else {
				Out.error("leaving中的",gameClient.channel,"不存在于onlineClients列表中");
			}
		}
		leavingClients.clear();
		Out.info("移除了",count,"个离线玩家");
	}
	
	
	
	
}
