package client;

import game.LogicDispatcher;
import game.Packet;
import game.Header.HeaderType;
import io.netty.channel.Channel;
import world.World;

public class Client {
	public Channel channel;
	public LogicDispatcher logicDispatcher;
	
	public Client(Channel channel) {
		this.channel=channel;
		logicDispatcher=World.getInstance().dispatchers[channel.id().hashCode()%World.getInstance().dispatchers.length];
		
		ClientManager.getInstance().onlineClients.put(channel, this);
	}
	
	
	public void pushPacket(String route,byte[] content) {
		Packet packet=new Packet(HeaderType.LogicRes, route, content, channel);
		channel.writeAndFlush(packet);
	}
}
