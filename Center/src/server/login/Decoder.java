package server.login;

import java.nio.charset.Charset;
import java.util.List;


import common.Config;
import common.Out;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToMessageDecoder;

public class Decoder extends MessageToMessageDecoder<ByteBuf> {
	
//	private static final ByteBuf HANDSHAKE;
//	/**心跳包*/
//	private static final ByteBuf HEARTBEAT;
//	static {
//		// {"code":200,"sys":{"heartbeat":30},"user":{"hand1":"aaa"}}
////		JSONObject res = new JSONObject();
////		res.put("code", 200);
////		JSONObject sys = new JSONObject();
////		sys.put("heartbeat", 30);
////		res.put("sys", sys);
////		byte[] bs = res.toJSONString().getBytes(GGlobal.UTF_8);
//		PomeloHeader head = new PomeloHeader();
//		head.setPomeloType(Protocol.TYPE_HANDSHAKE);
//		head.setLength(bs.length);
//		HANDSHAKE = BufferUtil.getAutoBuffer(PomeloHeader.SIZE + bs.length);
//		head.encode(HANDSHAKE);
//		HANDSHAKE.writeBytes(bs);
//		
//		PomeloHeader head_hb = new PomeloHeader();
//		head_hb.setPomeloType(Protocol.TYPE_HEARTBEAT);
//		head_hb.setLength(0);
//		HEARTBEAT = BufferUtil.getAutoBuffer(PomeloHeader.SIZE);
//		head_hb.encode(HEARTBEAT);
//	}
	
//	@Override
//	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
////		ByteBuf byteBuf=(ByteBuf)out.get(0);
//		Out.debug(out.size());
//		Out.debug(in.readableBytes());
//		
//	}

//	@Override
//	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//		// TODO Auto-generated method stub
//		Out.debug(msg);
//	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
//		Out.debug(msg.readableBytes());
//		Out.debug(msg.readByte());
//		Out.debug(msg.readByte());
//		Out.debug(msg.readByte());
//		Out.debug(msg.readByte());
//		Out.debug(msg.readByte());
//		Out.debug(msg.readByte());
//		Out.debug(msg.toString(Charset.defaultCharset()));
		out.add(msg.toString(Charset.defaultCharset()));
	}

}
