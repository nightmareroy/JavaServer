package server.center;

import java.util.List;
import java.util.Map;

import common.Out;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

public final class Encoder extends MessageToByteEncoder<Packet> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
		// TODO Auto-generated method stub
		if(msg==null||msg.header==null) {
			throw new Exception("The encode msg is null!");
		}
		ByteBuf sendBuf = Unpooled.buffer();
		sendBuf.writeInt(msg.header.crcCode);
		sendBuf.writeInt(msg.header.length);
		sendBuf.writeLong(msg.header.sessionID);
		sendBuf.writeByte(msg.header.type);
		sendBuf.writeBytes(msg.body);
		out.writeBytes(sendBuf);
		
	}

}
