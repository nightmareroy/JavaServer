package managerGameClient;

import common.Out;
import io.netty.channel.Channel;
import managerWorld.CenterWorld;
import protoCenterGame.Register.BindMsgRequest;
import serverGame.LogicDispatcher;
import serverGame.Packet;
import serverGame.Header.HeaderType;

public class GameClient {
	public Channel channel;
	public LogicDispatcher logicDispatcher;
	public boolean isOnline;
	
	
	public int gameClientId = -1;
	public String gameClientName = null;
	
	public GameClient(Channel channel) {
		this.channel=channel;
		this.logicDispatcher=CenterWorld.getInstance().getALogicDispatcher();
		this.isOnline=true;
//		GameClientManager.getInstance().registerClient(this);
	}
	
	
	public void pushPacket(String route,byte[] content) {
		Packet packet=new Packet(HeaderType.LogicRes, route, content, channel);
		channel.writeAndFlush(packet);
	}
	
	
	public void bindMsg(BindMsgRequest bindMsgRequest) {
		this.gameClientId = bindMsgRequest.getClientId();
		this.gameClientName = bindMsgRequest.getName();
		
		Out.debug("bind game client name:",gameClientName);
	}
}
