package protoCenterGame;


import com.google.protobuf.InvalidProtocolBufferException;

import handlerInterfaces.IHandler;
import io.netty.channel.Channel;
import protoCenterGame.Test.TestRequest;
import protoCenterGame.Test.TestResponse;
import serverGame.LogicPacket;

public class TestHandler implements IHandler {
	@Override
	public byte[] handle(LogicPacket logicPacket) {
		TestRequest testRequest = null;
		try {
			testRequest=TestRequest.parseFrom(logicPacket.content);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		TestResponse.Builder testResponseBuilder=TestResponse.newBuilder();
		
		//处理逻辑start
		
		
		//处理逻辑end
		return testResponseBuilder.build().toByteArray();
	}

}
