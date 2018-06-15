package handler;


import handler.base.IHandler;
import test.Packet.TestRequest;
import test.Packet.TestResponse;

public class TestHandler implements IHandler<TestRequest,TestResponse> {

	@Override
	public TestResponse handler(TestRequest t) {
		// TODO Auto-generated method stub
		return TestResponse.newBuilder().build();
	}

}
