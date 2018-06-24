package game;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import client.Client;
import client.ClientManager;
import common.Config;
import common.DataUtil;
import common.Out;
import game.Packet;
import game.Header.HeaderType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class Decoder extends LengthFieldBasedFrameDecoder {
	
	public Decoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment,
			int initialBytesToStrip) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
		// TODO Auto-generated constructor stub
	}




	private Map<String, Boolean> nodeCheck=new HashMap<>();


	

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf frame=(ByteBuf)super.decode(ctx, in);
		if(frame==null) {
			return null;
		}

		
		Packet packet=new Packet(ctx.channel());
		Header header=new Header();
		header.crcCode=frame.readInt();
		header.length=frame.readInt();
		header.type=frame.readByte();
		
		byte[] body=new byte[header.length];
		frame.readBytes(body);
		packet.header=header;
		packet.body=body;
		
		if(header.crcCode!=Config.CenterServer.Packet.crcCode) {
			return null;
		}
		
		InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
		
		HeaderType headerType=HeaderType.getHeaderType(header.type);
		if(headerType==null) {
			throw new Exception("找不到header type定义！");
		}
		
		
		switch (headerType) {
		case LogicReq:
			LogicPacket logicPacket=new LogicPacket(packet);
			
			Client client=ClientManager.getInstance().onlineClients.get(logicPacket.packet.channel);
			client.logicDispatcher.addPacket(logicPacket);
			break;
		case LogicRes:
					
			break;
		case WorkOneWay:
			
			break;
		case LoginReq:
			
			
			//如果开启白名单，检测
			if(Config.CenterServer.WhiteList.Enable) {
				if(!Arrays.asList(Config.CenterServer.WhiteList.List).contains(remoteAddress.getAddress().getHostAddress()))
				{
					ctx.writeAndFlush(new Packet(HeaderType.LoginRes,DataUtil.int2bytes(-1),ctx.channel()));
					break;
				}
			}
			//检测重复登录
			if(nodeCheck.containsKey(remoteAddress.toString())) {
				ctx.writeAndFlush(new Packet(HeaderType.LoginRes,DataUtil.int2bytes(-1),ctx.channel()));
				break;
			}
			
			nodeCheck.put(remoteAddress.toString(), true);
			
			new Client(packet.channel);
			
			
			ctx.writeAndFlush(new Packet(HeaderType.LoginRes,DataUtil.int2bytes(0),ctx.channel()));
			Out.debug(remoteAddress,"登录");
			break;
		case LoginRes:
			
			break;
		case BeatReq:
			ctx.writeAndFlush(new Packet(HeaderType.BeatRes,ctx.channel()));
			break;
		case BeatRes:
			
			break;
		case LogoutReq:
			
			break;
		default:
			break;
		}
		
		return null;
	}
	

	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
		
		//cause.printStackTrace();
		
//		if(cause instanceof ReadTimeoutException) {
//			InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
//			nodeCheck.remove(remoteAddress.toString());
//			Out.info(remoteAddress.toString(),"连接超时，移除出节点列表！");
//			ctx.close();
//		}
//		else {
//			InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
//			nodeCheck.remove(remoteAddress.toString());
//			Out.info(remoteAddress.toString(),"其他异常，移除出节点列表！");
//			ctx.close();
//		}
		
		
        //ctx.fireExceptionCaught(cause);
		
		InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
		nodeCheck.remove(remoteAddress.toString());
		Out.info(remoteAddress.toString(),cause.toString());
		ctx.close();
    }
	
	
}
