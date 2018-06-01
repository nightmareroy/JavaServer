package server.center;

import com.google.protobuf.MessageOrBuilder;

import common.Config.CenterServer.Packet;

public class WorkPacket extends Packet {
	public String route;
//	public 
	public MessageOrBuilder content;
}
