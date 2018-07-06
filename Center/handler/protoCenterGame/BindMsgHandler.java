package protoCenterGame;


import com.google.protobuf.InvalidProtocolBufferException;

import common.Out;
import handlerInterfaces.IHandler;
import io.netty.channel.Channel;
import managerGameClient.GameClientManager;
import protoCenterGame.Register.BindMsgRequest;
import serverGame.LogicPacket;


public class BindMsgHandler implements IHandler {
	@Override
	public byte[] handle(LogicPacket logicPacket) {
		BindMsgRequest bindMsgRequest = null;
		try {
			bindMsgRequest=BindMsgRequest.parseFrom(logicPacket.content);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		
		//处理逻辑start
		GameClientManager.getInstance().getOnlineClient(logicPacket.packet.channel).bindMsg(bindMsgRequest);
		
		//处理逻辑end
		return new byte[0];
	}

}
