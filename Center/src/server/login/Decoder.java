package server.login;

import java.util.List;


import common.Config;
import common.Out;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder {
	
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
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
//		ByteBuf byteBuf=(ByteBuf)out.get(0);
		Out.info(out.size());
		
	}

}
