package handler;


import com.google.protobuf.InvalidProtocolBufferException;

import interfaces.IHandler;
import test.Packet.TestRequest;
import test.Packet.TestResponse;

public class TestHandler implements IHandler {
	@Override
	public byte[] handle(byte[] requestBytes) {
		TestRequest testRequest;
		try {
			testRequest=TestRequest.parseFrom(requestBytes);
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		TestResponse.Builder testResponseBuilder=TestResponse.newBuilder();
		
		//处理逻辑start
		
		
		//处理逻辑end
		return testResponseBuilder.build().toByteArray();
	}

}
