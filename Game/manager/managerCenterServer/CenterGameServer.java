package managerCenterServer;

import clientCenter.Header.HeaderType;
import clientCenter.LogicDispatcher;
import clientCenter.Packet;
import io.netty.channel.Channel;
import managerWorld.GameWorld;


public class CenterGameServer {
	public static Channel channel;
	public static LogicDispatcher logicDispatcher;
	
//	private static Server server=null;
	
//	private Server(Channel channel) {
//		this.channel=channel;
//		logicDispatcher=World.getInstance().dispatchers[channel.id().hashCode()%World.getInstance().dispatchers.length];
//		
//		ClientManager.getInstance().onlineClients.put(channel, this);
//	}
	
	public static void registerChannel(Channel channel) {
		CenterGameServer.channel=channel;
	}
	
//	public static Server getInstance() {
//		if(server==null) {
//			server=new Server(channel);
//		}
//	}
	
	
	public void pushPacket(String route,byte[] content) {
		Packet packet=new Packet(HeaderType.LogicRes, route, content, channel);
		channel.writeAndFlush(packet);
	}
}
