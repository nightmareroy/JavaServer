package client.login;

import java.net.URI;

import common.Config;
import common.Out;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;


public class LoginClient {
	static Bootstrap clientBootstrap=new Bootstrap();
	
	public static void init() {
		
        EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			clientBootstrap
				.group(workerGroup)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {  
				    @Override  
				    protected void initChannel(SocketChannel ch) throws Exception {  
				        ch.pipeline()  
				        	.addLast(new LengthFieldPrepender(Config.LoginServer.Packet.lengthFieldLength));
//					        .addLast(new Handler());
				    }
				});
//			ChannelFuture f = clientBootstrap.bind(Config.LoginClient.port).sync(); 
//
//            f.channel().closeFuture().sync();
//            Out.info("client bind");
			Out.info("connect");
			ChannelFuture f = clientBootstrap.connect(Config.LoginServer.url, Config.LoginServer.port).sync();
			Out.info("connect over");
			String txt = "ABCDEFG";
			byte[] data = txt.getBytes();
			ByteBuf bb = Unpooled.buffer();
			bb.writeBytes(data, 0, data.length);
			Out.info("writeAndFlush");
	        f.channel().writeAndFlush(bb);
	        Out.info("close");
	        f.channel().closeFuture().sync();
	        
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            workerGroup.shutdownGracefully();
            Out.info("login client shutdown");
        }
		 
	}
	
	public static void request() {
		try {
			ChannelFuture f = clientBootstrap.connect(Config.LoginServer.url, Config.LoginServer.port).sync();
//			URI uri = new URI("http://"+Config.LoginServer.url+":"+Config.LoginServer.port);
//			String msg = "Are you ok?";
//	        DefaultFullHttpRequest request = new DefaultFullHttpRequest(
//	                HttpVersion.HTTP_1_1, HttpMethod.POST, uri.toASCIIString(),
//	                Unpooled.wrappedBuffer(msg.getBytes()));
//	        // 构建http请求
//	        request.headers().set(HttpHeaderNames.HOST, Config.LoginServer.url);
//	        request.headers().set(HttpHeaderNames.CONNECTION,
//	                HttpHeaderNames.CONNECTION);
//	        request.headers().set(HttpHeaderNames.CONTENT_LENGTH,
//	                request.content().readableBytes());
//	        request.headers().set("messageType", "normal");
//	        request.headers().set("businessType", "testServerState");
	        // 发送http请求
			
			String txt = "ABCDEFG_";
			byte[] data = txt.getBytes();
			ByteBuf bb = Unpooled.buffer();
			bb.writeBytes(data, 0, data.length);
			
	        f.channel().writeAndFlush(bb);
	        f.channel().closeFuture().sync();
	        Out.info("request");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
	}
}
