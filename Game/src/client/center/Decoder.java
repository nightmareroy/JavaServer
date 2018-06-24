package client.center;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import client.center.Packet;
import client.center.Header.HeaderType;
import common.Config;
import common.DataUtil;
import common.Out;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

public class Decoder extends LengthFieldBasedFrameDecoder {
	


	public Decoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment,
			int initialBytesToStrip) {
		super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf frame=(ByteBuf)super.decode(ctx, in);
		if(frame==null) {
			return null;
		}
		
		Packet message=new Packet();
		Header header=new Header();
		header.crcCode=frame.readInt();
		header.length=frame.readInt();
		//header.sessionID=frame.readLong();
		header.type=frame.readByte();
		
		byte[] body=new byte[header.length];
		frame.readBytes(body);
		message.header=header;
		message.body=body;
		
		if(header.crcCode!=Config.CenterServer.Packet.crcCode) {
			return null;
		}
		
		//InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
		
		
		
		
		HeaderType headerType=HeaderType.getHeaderType(header.type);
		if(headerType==null) {
			throw new Exception("找不到header type定义！");
		}
		switch (headerType) {
		case LogicReq:
			
			break;
		case LogicRes:
					
			break;
		case WorkOneWay:
			
			break;
		case LoginReq:
			
			
			
			
			break;
		case LoginRes:
			int result=DataUtil.bytes2int(message.body);
			if(result==0) {
				ctx.executor().scheduleAtFixedRate(()->{
					ctx.writeAndFlush(new Packet(HeaderType.BeatReq));
				}, 0, Config.CenterServer.HeartBeat, TimeUnit.SECONDS);
				
				InetSocketAddress remoteAddress=(InetSocketAddress)ctx.channel().remoteAddress();
				Out.debug("登录到",remoteAddress);
			}
			break;
		case BeatReq:
			
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
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        ctx.writeAndFlush(new Packet(HeaderType.LoginReq));
    }
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
		
		//cause.printStackTrace();
		Out.error(cause);
		ctx.executor().shutdownGracefully();
		ctx.close();
		LoginClient.checkAndConnect();
        //ctx.fireExceptionCaught(cause);
    }
	

}
