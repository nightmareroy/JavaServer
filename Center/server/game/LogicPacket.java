package game;

import java.util.Arrays;

import common.DataUtil;


public class LogicPacket{
	
	public Packet packet;
	public String route;
//	public 
	public byte[] content;
//	public DynamicMessage content;
	
	public LogicPacket(Packet packet) throws Exception{
		this.packet=packet;
		
		if(packet.body.length<4)
		{
			throw new Exception("body is too small!");
		}
		
		byte[] routeLengthByte=Arrays.copyOfRange(packet.body, 0, 4);
		int routeLength=DataUtil.bytes2int(routeLengthByte);
		
		if(packet.body.length<4 + routeLength)
		{
			throw new Exception("body is too small!");
		}
		
		byte[] routeByte=Arrays.copyOfRange(packet.body, 4, 4 + routeLength);
		route=new String(routeByte);
		
//		content=DynamicMessage.parseFrom(LogicDispatcher.handlerDescriptorMap.get(route).getInputType(), Arrays.copyOfRange(body, 4, body.length-4));

		content = Arrays.copyOfRange(packet.body, 4, packet.body.length-4);
		
	}


	
	
}
