package server.login;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DecoderException;
import common.Out;

import java.io.IOException;

import com.google.protobuf.Message;


public class Handler  extends SimpleChannelInboundHandler<String> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// TODO Auto-generated method stub
		Out.info(msg);
	}
	
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		Out.info("连接被建立，Session:", ctx.channel().remoteAddress());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// IO异常，只输出概要信息就可以了...
		if (cause instanceof IOException || cause instanceof DecoderException) {
			Out.debug("Netty try IOException||DecoderException.", ctx.channel().remoteAddress(), cause.getMessage());
		} else {
			Out.error("Netty try exception.", ctx.channel().remoteAddress(), cause);
		}
		ctx.close();
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		Channel session = ctx.channel();
		Out.info("连接被关闭:", session.remoteAddress());
//		try {
//			if (session.attr(GGlobal.__KEY_PLAYER) != null) {
//				GPlayer player = session.attr(GGlobal.__KEY_PLAYER).get();
//				if (player != null && player.getSession() == session) {
//					player.doLogout(false);
//				}
//			}
//		} finally {
//			GGame.getInstance().onSessionClose(session);
//		}
	}
    
}
