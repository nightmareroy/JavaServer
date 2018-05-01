package server.login;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import common.Out;
import com.google.protobuf.Message;

public class Handler  extends SimpleChannelInboundHandler<Packet> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
		// TODO Auto-generated method stub
		Out.info(msg.id,",,,",msg.value);
	}
    
}
